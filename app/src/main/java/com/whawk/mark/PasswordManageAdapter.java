package com.whawk.mark;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.GravityCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

class PasswordManageAdapter extends RecyclerView.Adapter<PasswordManageAdapter.MyViewHolder> {

    private List<DataEntry> dataEntries;
    private static Context context;


    public PasswordManageAdapter(Context context, List<DataEntry> dataEntries) {
        this.context = context;
        this.dataEntries = dataEntries;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.manage_password_template, parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        final DataEntry entry = dataEntries.get(position);

        holder.title_textview.setText(entry.getTitle());
        holder.sr_no.setText(String.valueOf(position + 1));
        //holder.username_textview.setText(entry.getUsername());
        holder.update_BT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                View data_entry_view = LayoutInflater.from(context).inflate(R.layout.activity_add, null);
                final AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setView(data_entry_view);
                builder.setCancelable(true);
                final Button saveBT = data_entry_view.findViewById(R.id.saveBT);
                saveBT.setText("Update");
                final EditText titleET = data_entry_view.findViewById(R.id.titleET);
                titleET.setText(entry.getTitle());
                titleET.setEnabled(false);

                final EditText usernameET = data_entry_view.findViewById(R.id.usernameET);
                usernameET.setText(entry.getUsername());

                final EditText password1ET = data_entry_view.findViewById(R.id.password1ET);
                password1ET.setText(entry.getPassword1());

                final EditText password2ET = data_entry_view.findViewById(R.id.password2ET);
                password2ET.setText(entry.getPassword2());

                final EditText pinET = data_entry_view.findViewById(R.id.pinET);
                pinET.setText(entry.getPin());

                final AlertDialog alertDialog = builder.create();

                saveBT.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (!TextUtils.isEmpty(titleET.getText())){
                            if (TextUtils.isEmpty(password1ET.getText())){
                                password1ET.setError("Enter! your "+titleET.getText().toString()+" password.");
                            }else{

                                final String title, username, password1, password2, pin;
                                title = titleET.getText().toString();
                                username = usernameET.getText().toString();
                                password1 = password1ET.getText().toString();
                                password2 = password2ET.getText().toString();
                                pin = pinET.getText().toString();
                                alertDialog.setCancelable(false);
                                titleET.setEnabled(false);
                                usernameET.setEnabled(false);
                                password1ET.setEnabled(false);
                                password2ET.setEnabled(false);
                                pinET.setEnabled(false);
                                saveBT.setText("Updating");
                                saveBT.setEnabled(false);

                                if(!ManageData.getInstance(context).updateData(new DataEntry(title,username,password1,password2,pin))){
                                    alertDialog.setCancelable(true);
                                    usernameET.setEnabled(true);
                                    password1ET.setEnabled(true);
                                    password2ET.setEnabled(true);
                                    pinET.setEnabled(true);
                                    saveBT.setEnabled(true);
                                }else{
                                    alertDialog.dismiss();
                                }

                            }
                        }else{
                            titleET.setError("Enter! website name.");
                        }
                    }
                });

                alertDialog.show();
            }
        });
        holder.delete_BT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                final AlertDialog.Builder builder = new AlertDialog.Builder(context);
                final AlertDialog dialog = builder.create();
                dialog.setCancelable(true);
                dialog.setTitle("Delete " + entry.getTitle() + "?");
                dialog.setMessage("Are you sure?");
                dialog.setButton(Dialog.BUTTON_POSITIVE, "YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (!ManageData.getInstance(context).deleteData(entry)){
                            Toast.makeText(context, "Deleted!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                dialog.setButton(Dialog.BUTTON_NEGATIVE, "NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialog.cancel();
                    }
                });
                dialog.show();

            }
        });
    }

    @Override
    public int getItemCount() {
        return dataEntries.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView title_textview, sr_no;
        ImageView delete_BT;
        Button update_BT;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            sr_no = itemView.findViewById(R.id.sr_no);
            title_textview = itemView.findViewById(R.id.title_textview);
            delete_BT = itemView.findViewById(R.id.delete_BT);
            update_BT = itemView.findViewById(R.id.update_BT);


        }
    }
}
