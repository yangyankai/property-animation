/*
 * Copyright (c) 2015-2015 by Shanghai shootbox Information Technology Co., Ltd.
 * Create: 2015/10/15 6:35:58
 * Project: TTT
 * File: MainActivity.java
 * Class: MainActivity
 * Module: app
 * Author: yangyankai
 * Version: 1.0
 */

package com.shootbox.ttt;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


	TextView btnAmateur;
	TextView btnProfession;


	private float   m_density;
	private boolean bOpen_amateur;


	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		bOpen_amateur = true;
		DisplayMetrics displayMetrics = new DisplayMetrics();
		displayMetrics = getResources().getDisplayMetrics();
		m_density = displayMetrics.density;


		btnAmateur = (TextView) findViewById(R.id.btn_amateur);
		btnProfession = (TextView) findViewById(R.id.btn_profession);


		btnAmateur.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view)
			{
				change();
			}

		});
		btnProfession.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view)
			{
				change();
			}
		});
	}

	private void change()
	{
		if (bOpen_amateur)
		{
			ObjectAnimator.ofFloat(btnAmateur, "TranslationX", 140).setDuration(500).start();
			ObjectAnimator.ofFloat(btnProfession, "TranslationX", -140).setDuration(500).start();
			bOpen_amateur = false;
		}
		else
		{
			ObjectAnimator.ofFloat(btnAmateur, "TranslationX", 0).setDuration(500).start();
			ObjectAnimator.ofFloat(btnProfession, "TranslationX", 0).setDuration(500).start();
			bOpen_amateur = true;
		}
	}
}
