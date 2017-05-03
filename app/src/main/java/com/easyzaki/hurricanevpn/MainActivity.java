package com.easyzaki.hurricanevpn;

import android.content.Intent;
import android.net.VpnService;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.easyzaki.hurricanevpn.service.HurricaneVpnService;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = VpnService.prepare(this);
        if (intent != null) {
            startActivityForResult(intent, 0);
        } else {
            onActivityResult(0, RESULT_OK, null);
        }
    }

    @Override
    protected void onActivityResult(int request, int result, Intent data) {
        if (result == RESULT_OK) {
            startService(new Intent(this, HurricaneVpnService.class));
        }
    }
}
