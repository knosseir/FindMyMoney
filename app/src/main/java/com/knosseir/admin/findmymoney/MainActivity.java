package com.knosseir.admin.findmymoney;

import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.customtabs.CustomTabsIntent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
        builder.setToolbarColor(Color.parseColor("#ff99cc00"));
        final CustomTabsIntent customTabsIntent = builder.build();

        MobileAds.initialize(this, "ca-app-pub-4503376707811079~8660084966");
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        final ListView listView = findViewById(R.id.state_listview);

        String[] states = {"Alabama", "Arkansas", "Arizona", "Alaska", "California", "Colorado", "Connecticut", "Delaware", "Florida", "Georgia", "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts", "Michigan", "Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire", "New Jersey", "New Mexico", "New York", "North Carolina", "North Dakota", "Ohio", "Oklahoma", "Oregon", "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas", "Utah", "Vermont", "Virginia", "Washington", "Washington D.C.", "West Virginia", "Wisconsin", "Wyoming"};
        final HashMap<String, String> links = new HashMap<>();

        links.put("Alabama", "https://alabama.findyourunclaimedproperty.com/");
        links.put("Alaska", "http://treasury.dor.alaska.gov/Unclaimed-Property.aspx");
        links.put("Arizona", "http://www.azunclaimed.gov/");
        links.put("Arkansas", "http://auditor.ar.gov/");
        links.put("California", "https://ucpi.sco.ca.gov/UCP/");
        links.put("Colorado", "https://colorado.findyourunclaimedproperty.com/");
        links.put("Connecticut", "https://www.ctbiglist.com/index.asp");
        links.put("Delaware", "https://finance.delaware.gov/unclaimedproperty.shtml");
        links.put("Florida", "https://www.fltreasurehunt.gov/");
        links.put("Georgia", "https://dor.georgia.gov/unclaimed-property-program");
        links.put("Hawaii", "https://www.ehawaii.gov/lilo/app");
        links.put("Idaho", "https://www.yourmoney.idaho.gov/");
        links.put("Illinois", "https://icash.illinoistreasurer.gov/");
        links.put("Indiana", "https://indianaunclaimed.gov/apps/ag/ucp/index.html");
        links.put("Iowa", "https://greatiowatreasurehunt.gov/");
        links.put("Kansas", "https://kansascash.com/prodweb/up/ownr_1.php");
        links.put("Kentucky", "https://treasury.ky.gov/Pages/index.aspx");
        links.put("Louisiana", "https://www.treasury.state.la.us/unclaimed-property-division/");
        links.put("Maine", "https://maineunclaimedproperty.gov/");
        links.put("Maryland", "https://interactive.marylandtaxes.com/individuals/unclaim/default.aspx");
        links.put("Massachusetts", "https://findmassmoney.com/");
        links.put("Michigan", "http://www.michigan.gov/treasury/0,1607,7-121-44435---,00.html");
        links.put("Minnesota", "https://mn.gov/commerce/consumers/your-money/find-missing-money/");
        links.put("Mississippi", "http://www.treasurerlynnfitch.ms.gov/unclaimedproperty/Pages/default.aspx");
        links.put("Missouri", "https://www.treasurer.mo.gov/unclaimedproperty/main.aspx");
        links.put("Montana", "http://revenue.mt.gov/home/businesses/unclaimed_property");
        links.put("Nebraska", "https://treasurer.nebraska.gov/up/");
        links.put("Nevada", "http://www.nevadatreasurer.gov/Unclaimed_Property/UP_Home/");
        links.put("New Hampshire", "https://www.nh.gov/treasury/unclaimed-property/index.htm");
        links.put("New Jersey", "http://www.unclaimedproperty.nj.gov/");
        links.put("New Mexico", "http://www.tax.newmexico.gov/Individuals/search-unclaimed-property.aspx");
        links.put("New York", "http://www.osc.state.ny.us/ouf/");
        links.put("North Carolina", "https://www.nctreasurer.com/Claim-Your-Cash/Claim-Your-NC_Cash/Pages/default.aspx");
        links.put("North Dakota", "https://land.nd.gov/UnclaimedProperty/");
        links.put("Oklahoma", "https://www.ok.gov/treasurer/Unclaimed_Property/index.html");
        links.put("Oregon", "http://www.oregon.gov/DSL/Money/Pages/Lost.aspx");
        links.put("Pennsylvania", "http://www.patreasury.gov/unclaimed-property/");
        links.put("Rhode Island", "http://www.treasury.ri.gov/treasury-divisions/unclaimed-property/");
        links.put("South Carolina", "https://southcarolina.findyourunclaimedproperty.com/");
        links.put("South Dakota", "https://southdakota.findyourunclaimedproperty.com/");
        links.put("Tennessee", "http://treasury.tn.gov/unclaim/index.html");
        links.put("Utah", "http://new.mycash.utah.gov/");
        links.put("Vermont", "https://secure2.vermonttreasurer.gov/unclaimed/ownerSearch.asp");
        links.put("Virginia", "https://www.vamoneysearch.org/");
        links.put("Washington", "http://ucp.dor.wa.gov/");
        links.put("Washington D.C.", "https://cfo.dc.gov/service/unclaimed-property");
        links.put("West Virginia", "http://www.wvtreasury.com/");
        links.put("Wisconsin", "https://www.revenue.wi.gov/Pages/UnclaimedProperty/Home.aspx");
        links.put("Wyoming", "https://statetreasurer.wyo.gov/UnclaimedProperty.aspx");


        final ArrayList<String> stateList = new ArrayList<>(Arrays.asList(states));

        final ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, stateList);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String selectedState = listView.getItemAtPosition(position).toString();
                String url = links.get(selectedState);

                if (url == null) {
                    Snackbar.make(listView, selectedState + " is not yet available.", Toast.LENGTH_SHORT).show();
                } else {
                    customTabsIntent.launchUrl(getBaseContext(), Uri.parse(url));
                }
            }
        });
    }
}