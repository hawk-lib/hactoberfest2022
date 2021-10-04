package com.whawk.mark;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.hardware.Camera;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.egroup.onetap.browser.WebSurf;
import com.egroup.onetap.call.ContactsAndPhoneDialer;
import com.egroup.onetap.launcher.dataBase.ApplicationDataBase;
import com.egroup.onetap.launcher.fragments.First;
import com.egroup.onetap.launcher.fragments.Fourth;
import com.egroup.onetap.launcher.fragments.Second;
import com.egroup.onetap.launcher.fragments.Third;
import com.egroup.onetap.launcher.setup.Setup;
import com.egroup.onetap.launcher.viewpagerTransition.AntiClockSpinTransformation;
import com.egroup.onetap.launcher.viewpagerTransition.ClockSpinTransformation;
import com.egroup.onetap.launcher.viewpagerTransition.CubeInDepthTransformation;
import com.egroup.onetap.launcher.viewpagerTransition.CubeInRotationTransformation;
import com.egroup.onetap.launcher.viewpagerTransition.CubeInScalingTransformation;
import com.egroup.onetap.launcher.viewpagerTransition.CubeOutDepthTransformation;
import com.egroup.onetap.launcher.viewpagerTransition.CubeOutRotationTransformation;
import com.egroup.onetap.launcher.viewpagerTransition.CubeOutScalingTransformation;
import com.egroup.onetap.launcher.viewpagerTransition.DepthTransformation;
import com.egroup.onetap.launcher.viewpagerTransition.FadeOutTransformation;
import com.egroup.onetap.launcher.viewpagerTransition.FanTransformation;
import com.egroup.onetap.launcher.viewpagerTransition.FidgetSpinTransformation;
import com.egroup.onetap.launcher.viewpagerTransition.GateTransformation;
import com.egroup.onetap.launcher.viewpagerTransition.HingeTransformation;
import com.egroup.onetap.launcher.viewpagerTransition.HorizontalFlipTransformation;
import com.egroup.onetap.launcher.viewpagerTransition.PopTransformation;
import com.egroup.onetap.launcher.viewpagerTransition.SpinnerTransformation;
import com.egroup.onetap.launcher.viewpagerTransition.TossTransformation;
import com.egroup.onetap.launcher.viewpagerTransition.VerticalFlipTransformation;
import com.egroup.onetap.launcher.viewpagerTransition.VerticalShutTransformation;
import com.egroup.onetap.launcher.viewpagerTransition.ZoomOutTransformation;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MyLauncher extends AppCompatActivity {

    ViewPager viewPager;
    FragmentAdapter fragmentAdapter;
    LinearLayout loading;
    int mainScreenPosition;
    SharedPreferences sharedPreferences;
    String transition;
    TabLayout tabLayout;

    ImageView callIV, webSurfIV, flashIV, setupIV;



    //DataBases
    ApplicationDataBase applicationDataBase;

    //ApplicationsList
    List<AppInfoHolderModel> homeAppsList, rightAppsList,leftAppsList, newAppsList;
    List<AppInfoHolderModel> installedApplications;


    //flashLight
    private Camera camera;
    Camera.Parameters params;
    CameraManager cameraManager;
    String mcameraId;
    private boolean hasFlash, isFlashOn = false;


    String textColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_launcher);




        callIV = findViewById(R.id.callIV);
        webSurfIV = findViewById(R.id.webSurfIV);
        flashIV = findViewById(R.id.flashIV);
        setupIV = findViewById(R.id.setupIV);

        init();
        viewPager = findViewById(R.id.viewpager);
        tabLayout = findViewById(R.id.tabLayout);
        sharedPreferences = getSharedPreferences("OneTap", 0);
        transition = sharedPreferences.getString("Transition", "ZoomOut");
        textColor = sharedPreferences.getString("TextColor", "White");
        viewPagerTransition();
        fragmentAdapter = new FragmentAdapter(getSupportFragmentManager());
        loading = findViewById(R.id.loading);
        new BackgroundTask().execute();

    }
    @Override
    public boolean onKeyDown(int keycode, KeyEvent event){

        if (keycode == KeyEvent.KEYCODE_HOME){

            return true;
        }
        else if (event.getKeyCode() == KeyEvent.KEYCODE_BACK){
            viewPager.setCurrentItem(mainScreenPosition);
            return true;
        }

        return false;
    }

    private void viewPagerTransition() {
        switch (transition) {
            case "None":
                viewPager.setPageTransformer(true, null);
                break;
            case "AntiClock Spin":
                viewPager.setPageTransformer(true, new AntiClockSpinTransformation());
                break;
            case "Clock Spin":
                viewPager.setPageTransformer(true, new ClockSpinTransformation());
                break;
            case "CubeIn Depth":
                viewPager.setPageTransformer(true, new CubeInDepthTransformation());
                break;
            case "CubeIn Rotation":
                viewPager.setPageTransformer(true, new CubeInRotationTransformation());
                break;
            case "CubeIn Scaling":
                viewPager.setPageTransformer(true, new CubeInScalingTransformation());
                break;
            case "CubeOut Depth":
                viewPager.setPageTransformer(true, new CubeOutDepthTransformation());
                break;
            case "CubeOut Rotation":
                viewPager.setPageTransformer(true, new CubeOutRotationTransformation());
                break;
            case "CubeOut Scaling":
                viewPager.setPageTransformer(true, new CubeOutScalingTransformation());
                break;
            case "Depth":
                viewPager.setPageTransformer(true, new DepthTransformation());
                break;
            case "FadeOut":
                viewPager.setPageTransformer(true, new FadeOutTransformation());
                break;
            case "Fan":
                viewPager.setPageTransformer(true, new FanTransformation());
                break;
            case "FidgetSpinTransformation":
                viewPager.setPageTransformer(true, new FidgetSpinTransformation());
                break;
            case "Gate":
                viewPager.setPageTransformer(true, new GateTransformation());
                break;
            case "Hinge":
                viewPager.setPageTransformer(true, new HingeTransformation());
                break;
            case "Horizontal Flip":
                viewPager.setPageTransformer(true, new HorizontalFlipTransformation());
                break;
            case "Pop":
                viewPager.setPageTransformer(true, new PopTransformation());
                break;
            case "Spinner":
                viewPager.setPageTransformer(true, new SpinnerTransformation());
                break;
            case "Toss":
                viewPager.setPageTransformer(true, new TossTransformation());
                break;
            case "Vertical Flip":
                viewPager.setPageTransformer(true, new VerticalFlipTransformation());
                break;
            case "Vertical Shut":
                viewPager.setPageTransformer(true, new VerticalShutTransformation());
                break;
            case "ZoomOut":
                viewPager.setPageTransformer(true, new ZoomOutTransformation());
                break;
        }
    }


    class BackgroundTask extends AsyncTask<String, Integer, Boolean> {


        @Override
        protected void onPreExecute() {
            loading.setVisibility(View.VISIBLE);
        }

        @Override
        protected Boolean doInBackground(String... params) {

            applicationDataBase = new ApplicationDataBase(getApplicationContext());
            applicationDataBase.openDB();
            applicationDataBase.readable();
            Cursor cursor = applicationDataBase.count();

            try{
                if (cursor.getCount() == 0){
                    loadApplicationsToDatabase();
                }else {

                    cursor.moveToFirst();
                    while (cursor.moveToNext()) {
                        String application = cursor.getString(cursor.getColumnIndex("Package"));
                        Intent intent = getPackageManager().getLaunchIntentForPackage(application);

                        if (intent == null) {
                            applicationDataBase.writable();
                            applicationDataBase.deleteApplication(application);
                        }
                    }

                    List<PackageInfo> packs = getPackageManager().getInstalledPackages(0);
                    for (int i = 0; i < packs.size(); i++) {
                        PackageInfo p = packs.get(i);
                        String appName = p.applicationInfo.loadLabel(getPackageManager()).toString();
                        Drawable icon = p.applicationInfo.loadIcon(getPackageManager());
                        String packages = p.applicationInfo.packageName;
                        Bitmap bitmap = ((BitmapDrawable) icon).getBitmap();
                        Intent intent = getPackageManager().getLaunchIntentForPackage(packages);


                        if (intent != null) {
                            boolean available = false;
                            cursor.moveToFirst();
                            while (cursor.moveToNext()) {
                                if (cursor.getString(cursor.getColumnIndex("Package")).equals(packages)) {
                                    available = true;
                                    break;
                                }
                            }
                            if (!available) {
                                applicationDataBase.writable();
                                applicationDataBase.addApplication(new AppInfoHolderModel(appName, bitmap, packages));
                            }
                        }
                    }
                }

            }catch (Exception e){
                Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
            } finally {
                try{
                    applicationDataBase.readable();
                    applicationDataBase.readData();
                    homeAppsList = applicationDataBase.homeApps();
                    leftAppsList = applicationDataBase.leftApps();
                    rightAppsList = applicationDataBase.rightApps();
                    newAppsList = applicationDataBase.newApps();




                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
                }
            }

            return true;
        }

        @Override
        protected void onPostExecute(Boolean result) {

            applicationDataBase.closeDB();

            loading.setVisibility(View.GONE);

            new Handler().post(new Runnable() {
                @Override
                public void run() {

                    if (leftAppsList.size() > 0) {
                        fragmentAdapter.addFragment(new Second(leftAppsList));
                    }
                    fragmentAdapter.addFragment(new First(homeAppsList));
                    mainScreenPosition = fragmentAdapter.getCount()-1;

                    if (rightAppsList.size() > 0) {
                        fragmentAdapter.addFragment(new Third(rightAppsList));
                    }
                    if (newAppsList.size() > 0) {
                        fragmentAdapter.addFragment(new Fourth(newAppsList));
                    }
                    viewPager.setAdapter(fragmentAdapter);
                    viewPager.setCurrentItem(mainScreenPosition);
                    tabLayout.setupWithViewPager(viewPager,true);
                    tabLayout.clearOnTabSelectedListeners();
                    for (View v :tabLayout.getTouchables()){
                        v.setEnabled(false);
                    }

                }
            });

            //new RunningBackground().execute();

        }

        private void loadApplicationsToDatabase() {
            applicationDataBase.writable();
            List<PackageInfo> packs = getPackageManager().getInstalledPackages(0);
            for (int i = 0; i < packs.size(); i++) {
                PackageInfo p = packs.get(i);
                String appName = p.applicationInfo.loadLabel(getPackageManager()).toString();
                Drawable icon = p.applicationInfo.loadIcon(getPackageManager());
                String packages = p.applicationInfo.packageName;
                Bitmap bitmap = ((BitmapDrawable)icon).getBitmap();
                Intent intent = getPackageManager().getLaunchIntentForPackage(packages);


                if (intent != null) {
                    applicationDataBase.addApplication(new AppInfoHolderModel(appName,bitmap,packages));

                }
            }
        }


    }

    private void init() {

        flashIV.setActivated(false);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            cameraManager = (CameraManager) getApplicationContext().getSystemService(Context.CAMERA_SERVICE);
            try {
                mcameraId = cameraManager.getCameraIdList()[0];
            } catch (CameraAccessException e) {
                e.printStackTrace();

            }
        } else {
            hasFlash = getApplicationContext().getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);
            if (!hasFlash) {
                Toast.makeText(getApplicationContext(), "Flash not Available!", Toast.LENGTH_SHORT).show();

            } else {
                try {
                    camera = Camera.open();
                    params = camera.getParameters();
                } catch (RuntimeException e) {
                    Log.e("Camera Error. Error : ", e.getMessage());
                }
            }
        }
    }

    /*protected void onUserLeaveHint(){
        viewPager.setCurrentItem(mainScreenPosition);
    }*/

   /*public void onBackPressed() {

    }*/


    public void openApp(View view) {

        int id = view.getId();
        if (id == R.id.callIV) {
            startActivity(new Intent(getApplicationContext(), ContactsAndPhoneDialer.class).putExtra("Activity", 1));
        } else if (id == R.id.webSurfIV) {
            startActivity(new Intent(getApplicationContext(), WebSurf.class));
        } else if (id == R.id.setupIV) {
            startActivity(new Intent(getApplicationContext(), Setup.class));
        } else if (id == R.id.flashIV) {

            if (isFlashOn == false) {
                flashIV.setActivated(true);
                turnOnLight();

            } else {
                flashIV.setActivated(false);
                turnOfflight();
            }
        }
    }

    private void turnOfflight() {
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                cameraManager.setTorchMode(mcameraId, false);
            } else {
                params.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
                camera.setParameters(params);
            }
            //torchIV.setImageResource(R.mipmap.torch_off);
            isFlashOn = false;

        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }

    private void turnOnLight() {
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                cameraManager.setTorchMode(mcameraId, true);
            } else {
                params.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
                camera.setParameters(params);
            }
            //torch.setImageResource(R.mipmap.torch_on);
            isFlashOn = true;
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (!transition.equals(sharedPreferences.getString("Transition", "none"))) {
            transition = sharedPreferences.getString("Transition", "none");
            viewPagerTransition();
        }
        //new BackgroundResumeTask().execute();

    }

    private class RunningBackground extends AsyncTask<String, Integer, Boolean>  {
        @Override
        protected Boolean doInBackground(String... strings) {

            installedApplications = new ArrayList<>();
            String appName;
            Bitmap bitmap;
            String packages;
            List<PackageInfo> packs = getPackageManager().getInstalledPackages(0);
            for (int i = 0; i < packs.size(); i++) {
                PackageInfo p = packs.get(i);
                appName = p.applicationInfo.loadLabel(getPackageManager()).toString();
                Drawable icon = p.applicationInfo.loadIcon(getPackageManager());
                packages = p.applicationInfo.packageName;
                bitmap = ((BitmapDrawable)icon).getBitmap();
                Intent intent = getPackageManager().getLaunchIntentForPackage(packages);


                if (intent != null) {
                    installedApplications.add(new AppInfoHolderModel(appName,bitmap,packages));

                }
            }



            applicationDataBase.openDB();
            applicationDataBase.readable();
            Cursor cursor = applicationDataBase.count();

            if(installedApplications.size()>cursor.getCount()){

                applicationDataBase.readable();
                for (int i = 0; i<installedApplications.size(); i++){
                    String packageName = installedApplications.get(i).getPackages();
                    if (applicationDataBase.checkPackage(packageName)== false){

                    }else{
                        applicationDataBase.writable();
                        //applicationDataBase.addApplication(new AppInfoHolderModel(appName,bitmap,packages));
                    }
                }
                Toast.makeText(getApplicationContext(),"New Application Found",Toast.LENGTH_SHORT).show();
            }else if (packs.size()<cursor.getCount()){



                Toast.makeText(getApplicationContext(),"Application Not Found",Toast.LENGTH_SHORT).show();
            }


            return true;
        }
    }
}

