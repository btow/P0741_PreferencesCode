package com.example.samsung.p0741_preferencescode;

import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceCategory;
import android.preference.PreferenceScreen;
import android.support.annotation.Nullable;

/**
 * Created by samsung on 05.04.2017.
 */

public class PrefActivity extends PreferenceActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Создание экрана
        PreferenceScreen rootScreen = getPreferenceManager().createPreferenceScreen(this);
        //Задание корневого экрана для Activity
        setPreferenceScreen(rootScreen);
        //Создание элементов, присвоение атрибутов и формирование иерархии
        CheckBoxPreference chb1 = new CheckBoxPreference(this);
        chb1.setKey("chb1");
        chb1.setTitle("Check Box 1");
        chb1.setSummaryOn("Descripton of check box 1 on");
        chb1.setSummaryOff("Descripton of check box 1 off");

        rootScreen.addPreference(chb1);

        ListPreference list = new ListPreference(this);
        list.setKey("list");
        list.setTitle("List");
        list.setSummary("Descripton of List");
        list.setEntries(R.array.entries);
        list.setEntryValues(R.array.entry_values);

        rootScreen.addPreference(list);

        CheckBoxPreference chb2 = new CheckBoxPreference(this);
        chb2.setKey("chb2");
        chb2.setTitle("Check Box 2");
        chb2.setSummary("Descripton of check box 2");

        rootScreen.addPreference(chb2);

        PreferenceScreen screen = getPreferenceManager().createPreferenceScreen(this);
        screen.setKey("screen");
        screen.setTitle("Screen");
        screen.setSummary("Descripton of Screen");

        final CheckBoxPreference chb3 = new CheckBoxPreference(this);
        chb3.setKey("chb3");
        chb3.setTitle("Check Box 3");
        chb3.setSummary("Descripton of check box 3");

        screen.addPreference(chb3);

        PreferenceCategory category1 = new PreferenceCategory(this);
        category1.setKey("categ1");
        category1.setTitle("Category 1");
        category1.setSummary("Descripton of category 1");

        screen.addPreference(category1);

        CheckBoxPreference chb4 = new CheckBoxPreference(this);
        chb4.setKey("chb4");
        chb4.setTitle("Check Box 4");
        chb4.setSummary("Descripton of check box 4");

        category1.addPreference(chb4);

        final PreferenceCategory category2 = new PreferenceCategory(this);
        category2.setKey("categ2");
        category2.setTitle("Category 2");
        category2.setSummary("Descripton of category 2");

        screen.addPreference(category2);

        CheckBoxPreference chb5 = new CheckBoxPreference(this);
        chb5.setKey("chb5");
        chb5.setTitle("Check Box 5");
        chb5.setSummary("Descripton of check box 5");

        category2.addPreference(chb5);

        CheckBoxPreference chb6 = new CheckBoxPreference(this);
        chb6.setKey("chb6");
        chb6.setTitle("Check Box 6");
        chb6.setSummary("Descripton of check box 6");

        category2.addPreference(chb6);

        rootScreen.addPreference(screen);

        list.setDependency("chb1");
        screen.setDependency("chb2");

        //Связь активности categ2 и значения chb3
        category2.setEnabled(chb3.isChecked());
        chb3.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                category2.setEnabled(chb3.isChecked());
                return false;
            }
        });
    }
}
