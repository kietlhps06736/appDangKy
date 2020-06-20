package com.example.appdangky.Activity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONObject;
import com.android.volley.VolleyError;
import com.example.appdangky.R;

import org.json.JSONException;

import java.util.HashMap;
import java.util.Map;

public class UserActivity extends AppCompatActivity {
    private RequestQueue mQueue;
    TextView tvId, tvMssv,tvTenSV,
            tvGioiTinh,tvSdt,tvEmail,
            tvDiaChi,tvNganh,tvTrangThai;
    int IdSV;
    String MaSV, TenSinhVien,GioiTinh,Phone,Email,DiaChi,Nganh,HocKy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        tvId = (TextView) findViewById(R.id.tvId);
        tvMssv = (TextView)findViewById(R.id.tvMSSV);
        tvTenSV = (TextView)findViewById(R.id.tvTen);
        tvGioiTinh = (TextView)findViewById(R.id.tvGioiTinh);
        tvSdt = (TextView)findViewById(R.id.tvSdt);
        tvEmail= (TextView)findViewById(R.id.tvEmail);
        tvDiaChi = (TextView)findViewById(R.id.tvDiachi);
        tvNganh = (TextView)findViewById(R.id.tvNganh);
        tvTrangThai = (TextView)findViewById(R.id.tvTrangThai);

        mQueue = Volley.newRequestQueue(this);

        jsonParse();
    }

    private void jsonParse() {
        String url = "https://dangkymonhoc.000webhostapp.com/API/getSinhVien.php";
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                       Log.d("a",response);
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            if (jsonObject.getInt("resultCode") == 1){
//                                JSONObject data = jsonObject.getJSONObject();


                                IdSV = jsonObject.getInt("IdSinhVien");
                                MaSV = jsonObject.getString("MaSinhVien");
                                TenSinhVien = jsonObject.getString("TenSinhVien");
                                GioiTinh = jsonObject.getString("GioiTinh");
                                Phone = jsonObject.getString("Phone_Number");
                                Email = jsonObject.getString("Email");
                                DiaChi = jsonObject.getString("DiaChi");
                                Nganh = jsonObject.getString("TenNganh");
//                                HocKy = jsonObject.getString("HocKy");
//sdfsdfs
                                tvId.setText(String.valueOf(IdSV));
                                tvMssv.setText(MaSV);
                                tvTenSV.setText(TenSinhVien);
                                tvGioiTinh.setText(GioiTinh);
                                tvEmail.setText(Email);
                                tvSdt.setText(Phone);
                                tvDiaChi.setText(DiaChi);
                                tvNganh.setText(Nganh);
//                                tvTrangThai.setText(HocKy);

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                params.put("id","1");
                return params;
//                return super.getParams();
            }
        };
        mQueue.add(stringRequest);
//        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url, null,
//                new Response.Listener<JSONObject>() {
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        Log.d("aaaa",response.toString());
//                        try {
//                            JSONArray jsonArray = response.getJSONArray("data");
////                            Toast.makeText(UserActivity.this,response.toString(), Toast.LENGTH_SHORT).show();
//                            for (int i = 0; i < jsonArray.length(); i++) {
//
//                                JSONObject data = jsonArray.getJSONObject(1);
//                                IdSV = data.getInt("IdSinhVien");
//                                MaSV = data.getString("MaSinhVien");
//                                TenSinhVien = data.getString("TenSinhVien");
//                                GioiTinh = data.getString("GioiTinh");
//                                Phone = data.getString("Phone_Number");
//                                Email = data.getString("Email");
//                                DiaChi = data.getString("DiaChi");
//                                Nganh = data.getString("TenNganh");
//                                HocKy = data.getString("HocKy");
//
//                                tvId.setText(String.valueOf(IdSV));
//                                tvMssv.setText(MaSV);
//                                tvTenSV.setText(TenSinhVien);
//                                tvGioiTinh.setText(GioiTinh);
//                                tvEmail.setText(Email);
//                                tvSdt.setText(Phone);
//                                tvDiaChi.setText(DiaChi);
//                                tvNganh.setText(Nganh);
//                                tvTrangThai.setText(HocKy);
//
//
//
//                            }
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
////                Toast.makeText(UserActivity.this,"Error!!", Toast.LENGTH_SHORT).show();
//
//                error.printStackTrace();
//            }
//        }){
//            @Override
//            protected Map<String, String> getParams() throws AuthFailureError {
//                Map<String,String> params = new HashMap<>();
//                params.put("IdSinhVien","1");
//                return params;
//            }
//        };
//        mQueue.add(request);
    }
}
