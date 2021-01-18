package com.example.alarms;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class RecyclerViewAlarms extends RecyclerView.Adapter<RecyclerViewAlarms.TypesListHolder> {


    private List<AlarmModel> listData;
    private LayoutInflater inflater;
    public  IChecking mListener;

    public RecyclerViewAlarms(List<AlarmModel> listData, Context context, IChecking mListener) {
        if (context == null)
            return;
        this.listData = listData;
        this.inflater = LayoutInflater.from(context);
        this.mListener = mListener;
    }

    public interface IChecking
    {
        void check(ImageView imageView);
    }


    @Override
    public RecyclerViewAlarms.TypesListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.alarm_card_view, parent, false);
        return new RecyclerViewAlarms.TypesListHolder(view);
    }

    @Override
    public void onBindViewHolder(final RecyclerViewAlarms.TypesListHolder holder, final int position) {

        /*Conctact item = listData.get(position);
        if (item != null) {
           holder.checkBox_Contact.setText(item.getName());
        }

         */
    }
    @Override
    public int getItemCount() {
        return listData.size();
    }

    class TypesListHolder extends RecyclerView.ViewHolder {

        private boolean isChecked = false;
        private ImageView imageCheck;
        private FrameLayout frameClickable;

        public TypesListHolder(final View itemView) {
            super(itemView);
            imageCheck = (ImageView) itemView.findViewById(R.id.imageCheck);
            frameClickable = (FrameLayout)itemView.findViewById(R.id.frameClickable);
            frameClickable.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(isChecked) {
                        imageCheck.setImageResource(R.drawable.avd_done_off);
                        mListener.check(imageCheck);
                        isChecked = false;
                    }
                    else
                    {
                        imageCheck.setImageResource(R.drawable.avd_done_on);
                        mListener.check(imageCheck);
                        isChecked = true;

                    }
                }
            });
        }
    }
}

