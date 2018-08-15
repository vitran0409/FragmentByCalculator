package com.example.vitran.demofragmentbycalculator.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.vitran.demofragmentbycalculator.R;

public class BanPhimFragment extends Fragment implements View.OnClickListener {
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btncong, btntru, btnnhan, btnchia, btncham, btndelete, btnbang;
    int dem = 0, dem2 = 0;
    Double sodau, sohai;
    String dau;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_banphim, container, true);



        btn1 = fragmentView.findViewById(R.id.bt1);
        btn2 = fragmentView.findViewById(R.id.bt2);
        btn3 = fragmentView.findViewById(R.id.bt3);
        btn4 = fragmentView.findViewById(R.id.bt4);
        btn5 = fragmentView.findViewById(R.id.bt5);
        btn6 = fragmentView.findViewById(R.id.bt6);
        btn7 = fragmentView.findViewById(R.id.bt7);
        btn8 = fragmentView.findViewById(R.id.bt8);
        btn9 = fragmentView.findViewById(R.id.bt9);
        btn0 = fragmentView.findViewById(R.id.bt0);
        btncong = fragmentView.findViewById(R.id.btcong);
        btntru = fragmentView.findViewById(R.id.bttru);
        btnnhan = fragmentView.findViewById(R.id.btnhan);
        btnchia = fragmentView.findViewById(R.id.btchia);
        btncham = fragmentView.findViewById(R.id.btcham);
        btndelete = fragmentView.findViewById(R.id.btxoa);
        btnbang = fragmentView.findViewById(R.id.btbang);


        onClickButton(btn1);
        onClickButton(btn2);
        onClickButton(btn3);
        onClickButton(btn4);
        onClickButton(btn5);
        onClickButton(btn6);
        onClickButton(btn7);
        onClickButton(btn8);
        onClickButton(btn9);
        onClickButton(btn0);
        onClickButton(btndelete);
        onClickButton(btncham);
        onClickButton(btncong);
        onClickButton(btntru);
        onClickButton(btnnhan);
        onClickButton(btnchia);
        onClickButton(btnbang);

        return fragmentView;
    }

    public void onClickButton(Button bt) {
        bt.setOnClickListener(this);
    }

    public void layso(Button bt) {
        DetailFragment fragmentkq = (DetailFragment) getFragmentManager().findFragmentById(R.id.fragmentkq);

        if (fragmentkq == null || !fragmentkq.isInLayout()) {
            Toast.makeText(getActivity(), "Lỗi sml", Toast.LENGTH_SHORT).show();
        } else {
            if (dem2 == 0) {
                String text = fragmentkq.tvkq.getText().toString().trim();
                if (text == "0" ) {
                    if(!bt.getText().equals(".")){
                        text = "";
                    }
                }
                fragmentkq.tvkq.setText(text + bt.getText());
            } else if (dem2 > 0) {
                fragmentkq.tvkq.setText("");
                String text = fragmentkq.tvkq.getText().toString().trim();
                fragmentkq.tvkq.setText(text + bt.getText());
                dem2--;
            }
        }
    }

    public void luuso(Button bt) {

        DetailFragment fragmentkq = (DetailFragment) getFragmentManager().findFragmentById(R.id.fragmentkq);
        dau = bt.getText().toString();
        String text = fragmentkq.tvkq.getText().toString();
        if(text==""){
            Toast.makeText(getActivity(), "Hãy nhập số !!!", Toast.LENGTH_SHORT).show();
        }else{
            sodau = Double.parseDouble(text);
            fragmentkq.tvkq.setText("0");
            dem++;
            dem2++;
        }
    }

    public void tinhtoan(Button bt) {
        DetailFragment fragmentkq = (DetailFragment) getFragmentManager().findFragmentById(R.id.fragmentkq);
        String text = fragmentkq.tvkq.getText().toString();

        sohai = Double.parseDouble(text);

        if (dau.equals("+")) {
            sodau = sodau + sohai;
        }
        if (dau.equals("-")) {
            sodau = sodau - sohai;
        }
        if (dau.equals("*")) {
            sodau = sodau * sohai;
        }
        if (dau.equals("/")) {
            if (sohai == 0) {
                Toast.makeText(getActivity(), "Số thứ 2 phải khác 0 !!! ", Toast.LENGTH_SHORT).show();
                sodau = sohai;
            } else {
                sodau = sodau / sohai;
            }

        }
        dau = bt.getText().toString();
        if (dau.equals("=")) {
            fragmentkq.tvkq.setText(sodau + "");
            dem2 = 0;
            dem = 0;
        } else {
            fragmentkq.tvkq.setText(sodau + "");
            dem2++;
        }


    }

    public void deleteInfo() {
        DetailFragment fragmentkq = (DetailFragment) getFragmentManager().findFragmentById(R.id.fragmentkq);
        fragmentkq.tvkq.setText("0");

        dem = 0;
        dem2 = 0;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btcham:
                layso(btncham);
                break;
            case R.id.bt1:
                layso(btn1);
                break;
            case R.id.bt2:
                layso(btn2);
                break;
            case R.id.bt3:
                layso(btn3);
                break;
            case R.id.bt4:
                layso(btn4);
                break;
            case R.id.bt5:
                layso(btn5);
                break;
            case R.id.bt6:
                layso(btn6);
                break;
            case R.id.bt7:
                layso(btn7);
                break;
            case R.id.bt8:
                layso(btn8);
                break;
            case R.id.bt9:
                layso(btn9);
                break;
            case R.id.bt0:
                layso(btn0);
                break;
            case R.id.btcong:
                if (dem == 0) {
                    luuso(btncong);
                    break;
                } else {
                    tinhtoan(btncong);
                    break;
                }
            case R.id.bttru:
                if (dem == 0) {
                    luuso(btntru);
                    break;
                } else {
                    tinhtoan(btntru);
                    break;
                }
            case R.id.btnhan:
                if (dem == 0) {
                    luuso(btnnhan);
                    break;
                } else {
                    tinhtoan(btnnhan);
                    break;
                }

            case R.id.btchia:
                if (dem == 0) {
                    luuso(btnchia);
                    break;
                } else {
                    tinhtoan(btnchia);
                    break;
                }
            case R.id.btxoa:
                deleteInfo();
                break;
            case R.id.btbang:
                if (dem == 0) {
                    luuso(btnbang);
                    break;
                } else {
                    tinhtoan(btnbang);
                    break;
                }
        }
    }
}
