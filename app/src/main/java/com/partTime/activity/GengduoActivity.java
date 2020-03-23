package com.partTime.activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.Toast;
import com.partTime.R;

public class GengduoActivity extends AppCompatActivity {
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gengduo);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

//    FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//
//        fab.setOnClickListener(new View.OnClickListener()
//    {
//        @Override
//        public void onClick (View view){
//        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                .setAction("Action", null).show();
//    }
//    });
//}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        addSubMenu(menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();


        if (id == R.id.action_settings) {
            return true;
        }
        if (id == R.id.action_game) {
            Toast.makeText(this, "你选择了游戏设置操作", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * 1.创建子菜单对象
     * 2.设置子菜单监听事件
     * 3.在创建菜单时创建子菜单
     */
    private void addSubMenu(Menu menu) {
        SubMenu subMenu = menu.addSubMenu("音效设置");
        MenuItem subMenu1 = subMenu.add("打开音效");
        MenuItem subMenu2 = subMenu.add("关闭音效");
        //设置监听事件
        subMenu1.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                Toast.makeText(GengduoActivity.this, "开启音效服务成功！", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }

}
