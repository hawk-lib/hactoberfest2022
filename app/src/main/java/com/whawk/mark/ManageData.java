package com.whawk.mark;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.widget.Toast;


public class ManageData {

    private Context context;
    private PasswordDB db;
    private static ManageData mInstance;
    private boolean result;
    static DatabaseReference databaseReference;
    static ValueEventListener listener;
    static BroadcastReceiver broadcastReceiver;


    public ManageData(Context context) {
        this.context = context;
        db = new PasswordDB(context);
    }


    public static synchronized ManageData getInstance(Context context){
        if(mInstance == null) {
            mInstance = new ManageData(context);
        }
        return mInstance;
    }

    public void startBroadcast(){

        broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                    databaseReference.removeEventListener(listener);
                    stopBroadcast();

            }
        };
        context.registerReceiver(broadcastReceiver, new IntentFilter("com.whawk.mark.FINISHED_LOADING"));
    }
    public void stopBroadcast(){
        context.unregisterReceiver(broadcastReceiver);
    }


    public boolean loadData(){

        result = false;
        databaseReference = FirebaseDatabase.getInstance().getReference()
                .child(SharedPrefManager.getInstance(context).getUid()).child("data");


        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(!dataSnapshot.exists()){
                    Toast.makeText(context," No record found! ", Toast.LENGTH_SHORT).show();
                }else{
                    startBroadcast();
                    databaseReference.addValueEventListener(listener);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        listener = databaseReference.child("data").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String title, username, password1, password2, pin;
                boolean flag = false;


                db.openDB(1);
                db.deleteAllData();
                int count = (int)dataSnapshot.getChildrenCount();
                try {
                    int i = 0;

                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        title = snapshot.getKey();
                        username = String.valueOf(snapshot.child("username").getValue());
                        password1 = String.valueOf(snapshot.child("password1").getValue());
                        password2 = String.valueOf(snapshot.child("password2").getValue());
                        pin = String.valueOf(snapshot.child("pin").getValue());

                        db.insertData(new DataEntry(title, username, password1, password2, pin));
                        i += 1;
                        if (i == count) {
                            context.sendBroadcast(new Intent("com.whawk.mark.FINISHED_LOADING"));
                        }
                        result = true;
                    }
                }catch (Exception e){

                }
                finally {
                    db.closeDB();
                    context.sendBroadcast(new Intent("com.whawk.mark.DATA_CHANGED"));
                }
            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(context, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        return result;

    }

    public boolean updateData(final DataEntry dataEntry){

        databaseReference = FirebaseDatabase.getInstance().getReference()
                .child(SharedPrefManager.getInstance(context).getUid()).child("data").child(dataEntry.getTitle());
        databaseReference.setValue(new DataEntry(dataEntry.getUsername(),dataEntry.getPassword1(), dataEntry.getPassword2(), dataEntry.getPin()))
                .addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(context, "Updated Succefully.", Toast.LENGTH_SHORT);
                    if (db.openDB(1)){
                        db.updateData(dataEntry);
                        db.closeDB();
                    }
                    result = true;

                } else {
                    result = false;
                }
            }
        });

        return result;
    }




    public boolean deleteData(final DataEntry dataEntry){

        result = false;
        databaseReference = FirebaseDatabase.getInstance().getReference()
                .child(SharedPrefManager.getInstance(context).getUid())
                .child("data").child(dataEntry.getTitle());
        databaseReference.removeValue(new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(@Nullable DatabaseError databaseError, @NonNull DatabaseReference databaseReference) {
                if (db.openDB(1)){
                    db.deleteData(dataEntry);
                    db.closeDB();
                    result = true;
                    context.sendBroadcast(new Intent("com.whawk.mark.DONE"));
                }
            }
        });

        return result;
    }


    public boolean addData(final DataEntry dataEntry){

        result = false;

        databaseReference = FirebaseDatabase.getInstance().getReference()
                .child(SharedPrefManager.getInstance(context).getUid()).child("data").child(dataEntry.getTitle());
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    Toast.makeText(context, "Already exist", Toast.LENGTH_SHORT).show();
                    result = false;
                }else {
                    databaseReference.setValue(new DataEntry(dataEntry.getUsername(), dataEntry.getPassword1(), dataEntry.getPassword2(), dataEntry.getPin()))
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        if (db.openDB(1)){
                                            db.insertData(dataEntry);
                                            result = true;
                                            db.closeDB();
                                        }
                                    } else {
                                        result = false;
                                    }

                                }
                            });
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        return result;
    }




    public boolean deleteOnDevice(){

        if (db.openDB(1)){
            db.deleteAllData();
            db.closeDB();
            context.sendBroadcast(new Intent("com.whawk.mark.DATA_CHANGED"));
            return true;
        }else {
            return false;
        }
    }
}
