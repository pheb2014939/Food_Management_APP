package com.example.androidfinaltest_b2014939;

import android.database.Cursor;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.TextView;
        import androidx.annotation.NonNull;
        import androidx.recyclerview.widget.RecyclerView;

public class TotalRVAdapter extends RecyclerView.Adapter<TotalRVAdapter.BillViewHolder> {
    private Cursor cursor;

    public void setCursor(Cursor cursor) {
        this.cursor = cursor;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public BillViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.total_rv_item, parent, false);
        return new BillViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BillViewHolder holder, int position) {
//            if (cursor != null && cursor.moveToPosition(position)) {
//                holder.bind(cursor);
//            }
        int newPosition = cursor.getCount() - 1 - position; // Reverse the position
        if (cursor != null && cursor.moveToPosition(newPosition)) {
            holder.bind(cursor);
        }
    }

    @Override
    public int getItemCount() {
        return cursor != null ? cursor.getCount() : 0;
    }

    public static class BillViewHolder extends RecyclerView.ViewHolder {
        private TextView tvMa, tvTenMon, tvTenKH, tvSL, tvTongTien;

        public BillViewHolder(@NonNull View itemView) {
            super(itemView);
            tvMa = itemView.findViewById(R.id.idTVMa);
            tvTenMon = itemView.findViewById(R.id.idTVTenmon);
            tvTenKH = itemView.findViewById(R.id.idTVTenKH);
            tvSL = itemView.findViewById(R.id.idTVSL);
            tvTongTien = itemView.findViewById(R.id.idTVTongTien);
        }

        public void bind(Cursor cursor) {
            String ma = cursor.getString(cursor.getColumnIndex("id"));
            String tenMon = cursor.getString(cursor.getColumnIndex("noodle_name"));
            String tenKH = cursor.getString(cursor.getColumnIndex("customer_name"));
            int sl = cursor.getInt(cursor.getColumnIndex("quantity"));
            double tongTien = cursor.getDouble(cursor.getColumnIndex("total_price"));

            tvMa.setText(ma);
            tvTenMon.setText(tenMon);
            tvTenKH.setText(tenKH);
            tvSL.setText(String.valueOf(sl));
            tvTongTien.setText(String.valueOf(tongTien));
        }
    }
}
