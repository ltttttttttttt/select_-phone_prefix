package com.lt.selectcountry.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.lt.select_country.CountryBean;
import com.lt.select_country.LtSelectCountryActivity;
import kotlin.jvm.functions.Function1;

/**
 * 创    建:  lt  2019/6/18--14:08    lt.dygzs@qq.com
 * 作    用:
 * 注意事项:
 */
public class TestActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LtSelectCountryActivity.setSelectListener(new Function1<String, Boolean>() {
            @Override
            public Boolean invoke(String s) {

                return Boolean.FALSE;
            }
        });

        startActivityForResult(new Intent(this, LtSelectCountryActivity.class), 0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            CountryBean countryBean = LtSelectCountryActivity.getCountryBean(data);
            if (countryBean != null) {
                Toast.makeText(this, countryBean.getZh(), Toast.LENGTH_LONG).show();
            }
        }
    }
}
