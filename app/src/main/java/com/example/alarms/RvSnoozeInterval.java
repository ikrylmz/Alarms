package com.example.alarms;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RvSnoozeInterval extends RecyclerView.Adapter<RvSnoozeInterval.TypesListHolder> {


    private List<IntervalModel> listData;
    private LayoutInflater inflater;
    public  IChecking mListener;

    private FrameLayout temp_frm;
    private ImageView temp_img;

   public RvSnoozeInterval(List<IntervalModel> listData, Context context, IChecking mListener) {
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
    public RvSnoozeInterval.TypesListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.interval_card_view, parent, false);
        return new RvSnoozeInterval.TypesListHolder(view);
    }

    @Override
    public void onBindViewHolder(final RvSnoozeInterval.TypesListHolder holder, final int position) {

        IntervalModel item = listData.get(position);

        if (item != null) {
        //   holder.checkBox_Contact.setText(item.getName());
        }



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
         imageCheck = (ImageView) itemView.findViewById(R.id.image_interval_check);
         frameClickable = (FrameLayout) itemView.findViewById(R.id.frm_interval_Clickable);

         frameClickable.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {

                 if(temp_frm != frameClickable)
                 {

                     temp_img.setImageResource(R.drawable.avd_done_off);
                     mListener.check(temp_img);

                     imageCheck.setImageResource(R.drawable.avd_done_on);
                     mListener.check(imageCheck);

                     temp_img = imageCheck;
                     temp_frm = frameClickable;
                 }

             }
         });
     }

 }
}

