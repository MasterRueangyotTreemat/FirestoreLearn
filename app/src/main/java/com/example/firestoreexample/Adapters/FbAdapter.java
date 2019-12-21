package com.example.firestoreexample.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.firestoreexample.ModelClasses.ModelClass;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;

import com.example.firestoreexample.R;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class FbAdapter extends FirestoreRecyclerAdapter <ModelClass, FbAdapter.FBViewHolder>{

    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public FbAdapter(@NonNull FirestoreRecyclerOptions<ModelClass> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull FBViewHolder holder, int position, @NonNull ModelClass model) {
        String userName = getSnapshots().getSnapshot(position).getId();
        holder.userNameTV.setText(userName);
        holder.userStatusTv.setText(model.getStatus());
    }

    @NonNull
    @Override
    public FBViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        return new FBViewHolder(LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.single_row, viewGroup, false));
    }

    public class FBViewHolder extends RecyclerView.ViewHolder{

        TextView userNameTV, userStatusTv;

        public FBViewHolder(@NonNull View singleRow) {
            super(singleRow);
            userNameTV = singleRow.findViewById(R.id.sr_userName);
            userStatusTv = singleRow.findViewById(R.id.sr_userStatus);
        }
    }
}
