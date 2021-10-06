package com.whawk.mark;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import java.util.List;

class PasswordViewAdapter extends RecyclerView.Adapter<PasswordViewAdapter.MyViewHolder> {

    private List<DataEntry> dataEntries;
    private static Context context;


    public PasswordViewAdapter(Context context, List<DataEntry> dataEntries) {
        this.context = context;
        this.dataEntries = dataEntries;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.password_template, parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {

        final DataEntry entry = dataEntries.get(position);

        holder.title_textview.setText(entry.getTitle());
        holder.username_textview.setText(entry.getUsername());
        holder.username_textview.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("username", holder.username_textview.getText().toString());
                clipboardManager.setPrimaryClip(clip);
                Toast.makeText(context, "username Copied!", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        holder.password1_textview.setText(entry.getPassword1());
        holder.password1_textview.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("password1", holder.password1_textview.getText().toString());
                clipboardManager.setPrimaryClip(clip);
                Toast.makeText(context, "password1 Copied!", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        if (entry.getPassword2().equals("")){
            holder.password2_LL.setVisibility(View.INVISIBLE);
        }else {
            holder.password2_textview.setText(entry.getPassword2());
            holder.password2_textview.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
                    ClipData clip = ClipData.newPlainText("password2", holder.password2_textview.getText().toString());
                    clipboardManager.setPrimaryClip(clip);
                    Toast.makeText(context, "password2 Copied!", Toast.LENGTH_SHORT).show();
                    return false;
                }
            });
        }
        if (entry.getPin().equals("")){
            holder.pin_LL.setVisibility(View.INVISIBLE);
        }else {
            holder.pin_textview.setText(entry.getPin());
            holder.pin_textview.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
                    ClipData clip = ClipData.newPlainText("pin", holder.pin_textview.getText().toString());
                    clipboardManager.setPrimaryClip(clip);
                    Toast.makeText(context, "pin Copied!", Toast.LENGTH_SHORT).show();
                    return false;
                }
            });
        }
        holder.sr_no.setText(String.valueOf(position + 1));

    }

    @Override
    public int getItemCount() {
        return dataEntries.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView title_textview, username_textview, password1_textview, password2_textview, pin_textview, sr_no;
        LinearLayout password2_LL, pin_LL;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            title_textview = itemView.findViewById(R.id.title_textview);
            username_textview = itemView.findViewById(R.id.username_textview);
            password1_textview = itemView.findViewById(R.id.password1_textview);
            password2_textview = itemView.findViewById(R.id.password2_textview);
            pin_textview = itemView.findViewById(R.id.pin_textview);
            sr_no = itemView.findViewById(R.id.sr_no);
            password2_LL = itemView.findViewById(R.id.password2_LL);
            pin_LL = itemView.findViewById(R.id.pin_LL);
        }
    }
}
