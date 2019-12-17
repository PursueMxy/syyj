package com.zhkj.syyj.Activitys;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.zhkj.syyj.Adapters.ForwardAdapter;
import com.zhkj.syyj.Adapters.GridAdapter;
import com.zhkj.syyj.Adapters.ShopChoiceAdapter;
import com.zhkj.syyj.CustView.BottomDialog;
import com.zhkj.syyj.R;
import com.zhkj.syyj.Utils.DateUtils;
import com.zhkj.syyj.Utils.MxyUtils;
import com.zhkj.syyj.Utils.RequstUrlUtils;
import com.zhkj.syyj.Utils.SDFileHelper;
import com.zhkj.syyj.Utils.ToastUtils;
import com.zhouyou.recyclerview.XRecyclerView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ForwardActivity extends AppCompatActivity implements View.OnClickListener {

    private XRecyclerView mRecyclerView;
    private static Context mContext;
    private GridLayoutManager mLayoutManager;
    private ForwardAdapter forwardAdapter;
    private TextView tv_content;
    private ArrayList<String> share_imgs=new ArrayList<>();
    private String content;
    private String task_id;
    private static ArrayList<Uri> urisList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forward);
        mContext = getApplicationContext();
        Intent intent = getIntent();
        task_id = intent.getStringExtra("task_id");
        content = intent.getStringExtra("content");
        share_imgs = intent.getStringArrayListExtra("share_imgs");
        InitUI();

    }

    private void InitData() {
        urisList.clear();
        try {
            for (int a = 0; a < share_imgs.size(); a++) {
                savePicture(RequstUrlUtils.URL.HOST + share_imgs.get(a));
            }
        }catch (Exception e){

        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        task_id = intent.getStringExtra("task_id");
        content = intent.getStringExtra("content");
        share_imgs = intent.getStringArrayListExtra("share_imgs");
    }

    private void InitUI() {
        findViewById(R.id.forward_btn_define).setOnClickListener(this);
        findViewById(R.id.forward_img_back).setOnClickListener(this);
        tv_content = findViewById(R.id.forward_tv_content);
        mRecyclerView = findViewById(R.id.forward_recyclerView);
        mRecyclerView.setNestedScrollingEnabled(false);
        mLayoutManager =new GridLayoutManager(mContext, 3);
        forwardAdapter = new ForwardAdapter(mContext);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setEnabledScroll(false);
        mRecyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
                outRect.set(MxyUtils.dpToPx(mContext, MxyUtils.getDimens(mContext, R.dimen.dp_10))
                        , 0
                        , MxyUtils.dpToPx(mContext, MxyUtils.getDimens(mContext, R.dimen.dp_10))
                        , MxyUtils.dpToPx(mContext, MxyUtils.getDimens(mContext, R.dimen.dp_5)));
            }
        });
        forwardAdapter.setListAll(share_imgs);
        mRecyclerView.setAdapter(forwardAdapter);
        tv_content.setText(content);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)){
            finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.forward_img_back:
                finish();
                break;
            case R.id.forward_btn_define:
                InitData();
                setClipboard();
                WechatDialog();
                break;
                default:
                    break;
        }
    }

    //转发微信弹出窗
    public void  WechatDialog(){
        final BottomDialog bottomDialog = new BottomDialog(this, R.style.ActionSheetDialogStyle);
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.dialog_forward, null);
        inflate.findViewById(R.id.dialog_forward_btn_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomDialog.dismiss();
            }
        });
        inflate.findViewById(R.id.dialog_forward_btn_shareToTimeLine).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareToTimeLine(content,urisList);
                bottomDialog.dismiss();
            }
        });
        bottomDialog.setContentView(inflate);
        bottomDialog.show();
    }

    public void setClipboard(){
//获取剪贴板管理器：
        ClipboardManager cm = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
// 创建普通字符型ClipData
        ClipData mClipData = ClipData.newPlainText("Label", content);
// 将ClipData内容放到系统剪贴板里。
        cm.setPrimaryClip(mClipData);
    }


    /**
     * 分享多图到朋友圈，多张图片加文字
     *
     * @param uris
     */
    private void shareToTimeLine(String title, ArrayList<Uri> uris) {
        Intent intent = new Intent();
        ComponentName cmp = new ComponentName("com.tencent.mm","com.tencent.mm.ui.LauncherUI");
        intent.setAction(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setComponent(cmp);
        startActivityForResult(intent, 0);
    }

    //Glide保存图片
    public void savePicture( String url){
        Glide.with(mContext).asBitmap().load(url).into(new SimpleTarget<Bitmap>() {
            @Override
            public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                saveToSystemGallery(mContext,resource);
            }
        });
    }

    public static void saveToSystemGallery(Context context, Bitmap bmp) {
        // 首先保存图片
        File appDir = new File(Environment.getExternalStorageDirectory(), "vgmap");
        if (!appDir.exists()) {
            appDir.mkdir();
        }
        String fileName = System.currentTimeMillis() + ".jpg";
        File file = new File(appDir, fileName);
        try {
            FileOutputStream fos = new FileOutputStream(file);
            bmp.compress(Bitmap.CompressFormat.JPEG, 100, fos);
            fos.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 其次把文件插入到系统图库
        try {
            MediaStore.Images.Media.insertImage(context.getContentResolver(),
                    file.getAbsolutePath(), fileName, null);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // 最后通知图库更新
        context.sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.parse(file.getAbsolutePath())));
        getImageContentUri(mContext,file);
         Uri uri;
//        try {
//            ApplicationInfo applicationInfo = mContext.getApplicationInfo();
//            int targetSDK = applicationInfo.targetSdkVersion;
//            if (targetSDK >= Build.VERSION_CODES.N && Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
//                uri = Uri.parse(android.provider.MediaStore.Images.Media.insertImage(mContext.getContentResolver(), file.getAbsolutePath(), fileName, null));
//            } else {
//                uri = Uri.fromFile(new File(file.getPath()));
//            }
//            urisList.add(uri);
//        } catch (Exception ex) {
//
//        }

    }

    public static Uri getImageContentUri(Context context, File imageFile) {
        String filePath = imageFile.getAbsolutePath();
        Cursor cursor = context.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                new String[] { MediaStore.Images.Media._ID }, MediaStore.Images.Media.DATA + "=? ",
                new String[] { filePath }, null);
        Uri uri = null;

        if (cursor != null) {
            if (cursor.moveToFirst()) {
                int id = cursor.getInt(cursor.getColumnIndex(MediaStore.MediaColumns._ID));
                Uri baseUri = Uri.parse("content://media/external/images/media");
                uri = Uri.withAppendedPath(baseUri, "" + id);
            }

            cursor.close();
        }

        if (uri == null) {
            ContentValues values = new ContentValues();
            values.put(MediaStore.Images.Media.DATA, filePath);
            uri = context.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
        }
        urisList.add(uri);
        return uri;
    }

}
