package com.gattal.asta.tayssirkit;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class RecyclerViewAdapter  extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private static final String TAG = "Adapter";
    private static final int HEADER_VIEW = 0 ;
    private static final int CONTENT_VIEW = 1 ;
    final private ListItemClickListener mOnClickListener;
    private int mNumberOfItems;
    String[] args;


    public RecyclerViewAdapter(int numberOfItems, ListItemClickListener listener){
        mNumberOfItems = numberOfItems;
        mOnClickListener = listener;
    }


    public void setData(String[] strings) {
        this.args = strings;
    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Log.d(TAG,"viewType: "+viewType);
        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.row_content;
        switch (viewType){
            case HEADER_VIEW:
                layoutIdForListItem= R.layout.header_content;
                break;
            case CONTENT_VIEW:
                layoutIdForListItem = R.layout.row_content;
                break;
        }

        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediatly = false;

        View v = inflater.inflate(layoutIdForListItem,parent,shouldAttachToParentImmediatly);

        return new MyViewHolder(v);

    }

    @Override
    public int getItemViewType(int position) {
        switch(position) {
            case 0:
                return HEADER_VIEW;
            default:
                return CONTENT_VIEW;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Log.d(TAG,"#"+position);
        if(position!=0)
        holder.bind(args[position-1],position);

    }

    @Override
    public int getItemCount() {
        if(args.length==0) return -1;
        else
            return args.length+1;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
                                        implements View.OnClickListener {

        TextView listText;
        ImageView image;

        public MyViewHolder(View itemView) {
            super(itemView);
            Log.i("jj","Type"+getItemViewType());

                listText = itemView.findViewById(R.id.list_item);
                image = itemView.findViewById(R.id.imageView2);

                listText.setOnClickListener(this);
                image.setOnClickListener(this);

        }



        void bind ( String text,int listItemIndex){

            if(listItemIndex!=0)
               listText.setText(text);
                if(text == "دليل الحاج" )
                    image.setImageResource(R.drawable.guide512);
                else if(text == "معلومات الحركة المرورية")
                    image.setImageResource(R.drawable.infotraffic512);
                else if(text == "من نحن") image.setImageResource(R.drawable.info512);
                else image.setImageResource(R.drawable.reportproblem512);


        }

        @Override
        public void onClick(View view) {
            int clickedPosition = getAdapterPosition();
            mOnClickListener.onListItemClick(clickedPosition);
        }
    }

    public interface  ListItemClickListener{
        void onListItemClick(int clickedItemIndex);

    }
}