package com.example.wulin.schoolmate;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.wulin.schoolmate.HomeActivity;

import java.util.List;

import static android.support.v4.app.ActivityCompat.startActivityForResult;
import static android.support.v4.content.ContextCompat.startActivity;

/**
 * Created by wulin on 2017/12/18.
 */

public class ObjectAdapter extends RecyclerView.Adapter<ObjectAdapter.ViewHolder> {
    private List<Object> mObjectList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        View objectView;
        ImageView headImage;
        TextView Name;
        TextView Time;
        TextView Thing;
        TextView Price;
        TextView Description;
        ImageView Pic1Image;
        ImageView Pic2Image;
        ImageView Pic3Image;


        public ViewHolder(View view){
            super(view);
            objectView = view;
            headImage = (ImageView) view.findViewById(R.id.head);
            Name = (TextView) view.findViewById(R.id.name);
            Time = (TextView) view.findViewById(R.id.time);
            Thing = (TextView) view.findViewById(R.id.thing);
            Price = (TextView) view.findViewById(R.id.price);
            Description = (TextView) view.findViewById(R.id.description);
            Pic1Image = (ImageView) view.findViewById(R.id.pic1);
            Pic2Image = (ImageView) view.findViewById(R.id.pic2);
            Pic3Image = (ImageView) view.findViewById(R.id.pic3);
        }
    }

    public ObjectAdapter(List<Object> objectList){
        mObjectList = objectList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.object_item,parent,false);
        final ViewHolder holder = new ViewHolder(view);
        holder.objectView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int position = holder.getAdapterPosition();
                Object object = mObjectList.get(position);
                Toast.makeText(v.getContext(),"you clicked view"+object.getName(),
                        Toast.LENGTH_SHORT).show();
                Intent intent  = new Intent(v.getContext(),DetailActivity.class);
                v.getContext().startActivity(intent);
            }
        });

        return holder;
    }
    @Override
    public void onBindViewHolder(ViewHolder holder,int position){
        Object object = mObjectList.get(position);
        holder.headImage.setImageResource(object.getHeadImageID());
        holder.Name.setText(object.getName());
        holder.Time.setText(object.getTime());
        holder.Thing.setText(object.getThing());
        holder.Price.setText(object.getPrice());
        holder.Description.setText(object.getDescription());
        holder.Pic1Image.setImageResource(object.getPic1ID());
        holder.Pic2Image.setImageResource(object.getPic2ID());
        holder.Pic3Image.setImageResource(object.getPic3ID());
    }
    @Override
    public int getItemCount(){
        return mObjectList.size();
    }
}
