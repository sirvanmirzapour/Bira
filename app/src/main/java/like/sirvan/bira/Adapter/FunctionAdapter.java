package like.sirvan.bira.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import like.sirvan.bira.Model.FunctionModel;
import like.sirvan.bira.R;

public class FunctionAdapter extends RecyclerView.Adapter<FunctionAdapter.MyHolder> {

    Context context;
    List<FunctionModel> model;

    public FunctionAdapter(Context context,  List<FunctionModel> model) {
        this.context = context;
        this.model = model;
    }


    @NonNull
    @Override
    public FunctionAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.rv_function, parent, false);
        return new FunctionAdapter.MyHolder(v) ;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.txtName.setText(model.get(position).getName());
        holder.rvTextViewFunctionOne.setText(model.get(position).getTitleOne());
        holder.rvTextViewFunctionTwo.setText(model.get(position).getTitleTwo());
        holder.rvTextViewFunctionThree.setText(model.get(position).getTitleThree());
    }

    @Override
    public int getItemCount() {
        return model.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView txtName;
        LinearLayout rvLinearLayoutFunctionOne,rvLinearLayoutFunctionTwo,rvLinearLayoutFunctionThree;
        TextView rvTextViewFunctionOne,rvTextViewFunctionTwo,rvTextViewFunctionThree;


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
