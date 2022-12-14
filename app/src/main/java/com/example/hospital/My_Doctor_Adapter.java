package com.example.hospital;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class My_Doctor_Adapter extends RecyclerView.Adapter<My_Doctor_Adapter.ViewHolder>{




    int[] images;
    Context context;

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView1 ,  textView3 ,  textView5 ,textView6;
        ImageView imageView;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View
            imageView = (ImageView) view.findViewById(R.id.image1);
            textView1 = (TextView) view.findViewById(R.id.docName);
            //textView2 = (TextView) view.findViewById(R.id.docExperience);
            textView3 = (TextView) view.findViewById(R.id.docPatientStory);
            //textView4 = (TextView) view.findViewById(R.id.docPrecedent);
            textView5 = (TextView) view.findViewById(R.id.docSpecialist);
            textView6 = (TextView) view.findViewById(R.id.docTimeAvailable);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    provider.intentTo(view.getContext(),doctor_details.class,getLayoutPosition());
                    System.out.println(getLayoutPosition());

                }
            });

        }

        public TextView getTextView1() {
            return textView1  ;
        }
       /* public TextView getTextView2() {
            return textView2  ;
        }*/
        /*public TextView getTextView3() {
            return textView3  ;
        }*/
       /* public TextView getTextView4() {
            return textView4  ;
        }*/
        public TextView getTextView5() {
            return textView5  ;
        }
        public TextView getTextView6() {
            return textView6  ;
        }


    }




    public My_Doctor_Adapter(Context context, int[] images) {
        this.context = context ;
        this.images = images;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(context)
                .inflate(R.layout.my_doctor, viewGroup, false);

        return new ViewHolder(view);
    }



    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        viewHolder.getTextView1().setText(provider.doctors.get(position).getFirstName() + provider.doctors.get(position).getLastName());
        viewHolder.getTextView6().setText(provider.doctors.get(position).getAvailableTime());
        viewHolder.getTextView5().setText(provider.doctors.get(position).getSpecialty());
        //viewHolder.getTextView3().setText(provider.doctors.get(position).getPatientStories());
        viewHolder.imageView.setImageResource(images[position]);

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return provider.doctors.size();
    }
}