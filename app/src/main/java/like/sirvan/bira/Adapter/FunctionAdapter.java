package like.sirvan.bira.Adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import like.sirvan.bira.App.MyAlertDialog;
import like.sirvan.bira.Model.FunctionModel;
import like.sirvan.bira.R;

public class FunctionAdapter extends RecyclerView.Adapter<FunctionAdapter.MyHolder> {

    GradientDrawable gdDefaultOne = new GradientDrawable();
    GradientDrawable gdDefaultTwo = new GradientDrawable();
    GradientDrawable gdDefaultThree = new GradientDrawable();
    Context context;
    List<FunctionModel> model;
    MyAlertDialog myAlertDialog;

    public FunctionAdapter(Context context, List<FunctionModel> model) {
        this.context = context;
        this.model = model;

    }


    @NonNull
    @Override
    public FunctionAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.rv_function, parent, false);
        return new FunctionAdapter.MyHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, @SuppressLint("RecyclerView") int position) {
        myAlertDialog = new MyAlertDialog(context);

        String name = model.get(position).getName();
        if (name.length() > 15) name = name.substring(0, 15);

        holder.txtName.setText(name);

        if (model.get(position).getTitleOne() != null) {
            String str = model.get(position).getTitleOne();
            if (model.get(position).getTitleOne().length() > 10) {
                str = model.get(position).getTitleOne().substring(0, 10);
            }
            holder.rvTextViewFunctionOne.setText(str);
            gdDefaultOne.setColor(Color.parseColor(model.get(position).getColorOne()));
            gdDefaultOne.setCornerRadius(50);
            holder.rvLinearLayoutFunctionOne.setBackground(gdDefaultOne);

            holder.rvLinearLayoutFunctionOne.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    myAlertDialog.Show("?????????? ???????? ???????? ????????????", model.get(position).getCodeOne(), model.get(position).getPhone());
                }
            });
        }
        if (model.get(position).getTitleTwo() != null) {
            String str = model.get(position).getTitleTwo();
            if (model.get(position).getTitleTwo().length() > 10) {
                str = model.get(position).getTitleTwo().substring(0, 10);
            }

            holder.rvTextViewFunctionTwo.setText(str);
            gdDefaultTwo.setColor(Color.parseColor(model.get(position).getColorTwo()));
            gdDefaultTwo.setCornerRadius(50);
            holder.rvLinearLayoutFunctionTwo.setBackground(gdDefaultTwo);

            holder.rvLinearLayoutFunctionTwo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    myAlertDialog.Show("?????????? ???????? ???????? ????????????", model.get(position).getCodeTwo(), model.get(position).getPhone());
                }
            });
        }
        if (model.get(position).getTitleThree() != null) {
            String str = model.get(position).getTitleThree();
            if (model.get(position).getTitleThree().length() > 10) {
                str = model.get(position).getTitleThree().substring(0, 10);
            }
            holder.rvTextViewFunctionThree.setText(str);
            gdDefaultThree.setColor(Color.parseColor(model.get(position).getColorThree()));
            gdDefaultThree.setCornerRadius(50);
            holder.rvLinearLayoutFunctionThree.setBackground(gdDefaultThree);
            holder.rvLinearLayoutFunctionThree.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    myAlertDialog.Show("?????????? ???????? ???????? ????????????", model.get(position).getCodeThree(), model.get(position).getPhone());
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return model.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView txtName;
        LinearLayout rvLinearLayoutFunctionOne, rvLinearLayoutFunctionTwo, rvLinearLayoutFunctionThree;
        TextView rvTextViewFunctionOne, rvTextViewFunctionTwo, rvTextViewFunctionThree;


        public MyHolder(@NonNull View itemView) {
            super(itemView);

            txtName = itemView.findViewById(R.id.rvTextViewFunctionName);
            rvLinearLayoutFunctionOne = itemView.findViewById(R.id.rvLinearLayoutFunctionOne);
            rvLinearLayoutFunctionTwo = itemView.findViewById(R.id.rvLinearLayoutFunctionTwo);
            rvLinearLayoutFunctionThree = itemView.findViewById(R.id.rvLinearLayoutFunctionThree);

            rvTextViewFunctionOne = itemView.findViewById(R.id.rvTextViewFunctionOne);
            rvTextViewFunctionTwo = itemView.findViewById(R.id.rvTextViewFunctionTwo);
            rvTextViewFunctionThree = itemView.findViewById(R.id.rvTextViewFunctionThree);

        }
    }

}
