package cn.hlq.greendaostudy;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.ArrayList;
import java.util.List;

import cn.hlq.greendaostudy.entity.DaoMaster;
import cn.hlq.greendaostudy.entity.DaoSession;
import cn.hlq.greendaostudy.entity.Student;
import cn.hlq.greendaostudy.entity.StudentDao;

public class MainActivity extends Activity {

    private MainActivity self = MainActivity.this;

    private DaoMaster daoMaster;
    private DaoSession daoSession;
    private StudentDao stuDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getStuDao();
        initView();
    }

    /**
     * 获取StudentDao
     */
    private void getStuDao() {
        // 创建数据
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(self, "hlq.db", null);
        daoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
        daoSession = daoMaster.newSession();
        stuDao = daoSession.getStudentDao();
    }

    private void initView() {
        // 新增一条数据
        findViewById(R.id.id_insert).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student stu = new Student(null, "001", "贺da宝", "男孩", "50");
                long end = stuDao.insert(stu);
                String msg = "";
                if (end > 0) {
                    msg = "001新增成功~";
                } else {
                    msg = "新增失败~";
                }
                stuDao.insert(new Student(null, "002", "贺er宝", "男人", "66"));
                stuDao.insert(new Student(null, "003", "贺san宝", "爷儿们", "23"));
                stuDao.insert(new Student(null, "004", "贺si宝", "男人", "65"));
                Toast.makeText(self, "001 002 003 004新增成功~", Toast.LENGTH_SHORT).show();
            }
        });
        // 新增List集合数据
        findViewById(R.id.id_insert_list).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Student> stuList = new ArrayList<Student>();
                stuList.add(new Student(null, "005", "贺利权", "小爷儿们", "43"));
                stuList.add(new Student(null, "006", "贺利权", "大爷儿们", "35"));
                stuList.add(new Student(null, "007", "贺利权", "老爷儿们", "99"));
                stuList.add(new Student(null, "008", "贺利权", "老少爷儿们", "88"));
                stuDao.insertInTx(stuList);
                Toast.makeText(self, "新增成功~", Toast.LENGTH_SHORT).show();
            }
        });
        // 查询所有
        findViewById(R.id.id_search_all).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Student> stuList = stuDao.queryBuilder().list();
                if (stuList != null) {
                    String searchAllInfo = "";
                    for (int i = 0; i < stuList.size(); i++) {
                        Student stu = stuList.get(i);
                        searchAllInfo += "id：" + stu.getStuId() + "编号：" + stu.getStuNo() + "姓名：" + stu.getStuName() + "性别：" + stu.getStuSex() + "成绩：" + stu.getStuScore() + "\n";
                    }
                    TextView tvSearchInfo = (TextView) findViewById(R.id.id_search_all_info);
                    tvSearchInfo.setText(searchAllInfo);
                }
            }
        });
        // 查询指定数据 查询姓名为"贺da宝"的信息
        findViewById(R.id.id_search_assign).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String searchAssignInfo = "";
                List<Student> stuList = stuDao.queryBuilder().where(StudentDao.Properties.StuName.eq("贺da宝")).list();
                for (int i = 0; i < stuList.size(); i++) {
                    Student stu = stuList.get(i);
                    searchAssignInfo += "id：" + stu.getStuId() + "编号：" + stu.getStuNo() + "姓名：" + stu.getStuName() + "性别：" + stu.getStuSex() + "成绩：" + stu.getStuScore() + "\n";
                }
                TextView tvSearchAssign = (TextView) findViewById(R.id.id_search_assign_info);
                tvSearchAssign.setText(searchAssignInfo);
            }
        });
        // 查询指定数据 查询姓名为"贺da宝"的信息并按照成绩排序-降序
        findViewById(R.id.id_search_assign_order_desc).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String searchAssignOrderDesc = "";
                List<Student> stuList = stuDao.queryBuilder().where(StudentDao.Properties.StuName.eq("贺利权")).orderDesc(StudentDao.Properties.StuScore).list();
                for (int i = 0; i < stuList.size(); i++) {
                    Student stu = stuList.get(i);
                    searchAssignOrderDesc += "id：" + stu.getStuId() + "编号：" + stu.getStuNo() + "姓名：" + stu.getStuName() + "性别：" + stu.getStuSex() + "成绩：" + stu.getStuScore();
                }
                TextView tvSearchOrderDesc = (TextView) findViewById(R.id.id_search_assign_order_desc_info);
                tvSearchOrderDesc.setText(searchAssignOrderDesc);
            }
        });
        // 查询指定数据 查询姓名为"贺da宝"的信息并按照成绩排序-升序
        findViewById(R.id.id_search_assign_order_asc).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String searchAssignOrderDesc = "";
                List<Student> stuList = stuDao.queryBuilder().where(StudentDao.Properties.StuName.eq("贺利权")).orderAsc(StudentDao.Properties.StuScore).list();
                for (int i = 0; i < stuList.size(); i++) {
                    Student stu = stuList.get(i);
                    searchAssignOrderDesc += "id：" + stu.getStuId() + "编号：" + stu.getStuNo() + "姓名：" + stu.getStuName() + "性别：" + stu.getStuSex() + "成绩：" + stu.getStuScore();
                }
                TextView tvSearchOrderDesc = (TextView) findViewById(R.id.id_search_assign_order_asc_info);
                tvSearchOrderDesc.setText(searchAssignOrderDesc);
            }
        });
        // 组合查询数据 查询姓名为"贺利权" 并且成绩小于等于60
        findViewById(R.id.id_search_combination).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String searchAssignOrderDesc = "";
                QueryBuilder<Student> stuQB = stuDao.queryBuilder();
                stuQB.where(StudentDao.Properties.StuName.eq("贺利权"), StudentDao.Properties.StuScore.le("60"));
                List<Student> stuList = stuQB.list();
                for (int i = 0; i < stuList.size(); i++) {
                    Student stu = stuList.get(i);
                    searchAssignOrderDesc += "id：" + stu.getStuId() + "编号：" + stu.getStuNo() + "姓名：" + stu.getStuName() + "性别：" + stu.getStuSex() + "成绩：" + stu.getStuScore() + "\n";
                }
                TextView tvSearchOrderDesc = (TextView) findViewById(R.id.id_search_combination_info);
                tvSearchOrderDesc.setText(searchAssignOrderDesc);
            }
        });
        // 查询所有返回数据 但只返回前三条数据
        findViewById(R.id.id_search_limit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Student> stuList = stuDao.queryBuilder().limit(3).list();
                if (stuList != null) {
                    String searchAllInfo = "";
                    for (int i = 0; i < stuList.size(); i++) {
                        Student stu = stuList.get(i);
                        searchAllInfo += "id：" + stu.getStuId() + "编号：" + stu.getStuNo() + "姓名：" + stu.getStuName() + "性别：" + stu.getStuSex() + "成绩：" + stu.getStuScore() + "\n";
                    }
                    TextView tvSearchInfo = (TextView) findViewById(R.id.id_search_limit_info);
                    tvSearchInfo.setText(searchAllInfo);
                }
            }
        });
        // 查询所有返回数据 但只返回前三条数据 并且跳过第一条数据
        findViewById(R.id.id_search_limit_offset).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Student> stuList = stuDao.queryBuilder().limit(3).offset(1).list();
                if (stuList != null) {
                    String searchAllInfo = "";
                    for (int i = 0; i < stuList.size(); i++) {
                        Student stu = stuList.get(i);
                        searchAllInfo += "id：" + stu.getStuId() + "编号：" + stu.getStuNo() + "姓名：" + stu.getStuName() + "性别：" + stu.getStuSex() + "成绩：" + stu.getStuScore() + "\n";
                    }
                    TextView tvSearchInfo = (TextView) findViewById(R.id.id_search_limit_offset_info);
                    tvSearchInfo.setText(searchAllInfo);
                }
            }
        });
        // 查询所有信息总条数
        findViewById(R.id.id_search_count).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int stuSumCount = stuDao.queryBuilder().list().size();
                TextView tvSearchInfo = (TextView) findViewById(R.id.id_search_count_info);
                tvSearchInfo.setText(stuSumCount);
            }
        });
        // 删除指定信息
        findViewById(R.id.id_delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stuDao.queryBuilder().where(StudentDao.Properties.StuName.eq("贺si宝")).buildDelete().executeDeleteWithoutDetachingEntities();
                Toast.makeText(self, "删除成功~", Toast.LENGTH_SHORT).show();
//                stuDao.delete(new Student()); // 删除指定对象
//                stuDao.deleteAll(); // 删除所有
            }
        });
        // 更新指定信息
        findViewById(R.id.id_update).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student student = stuDao.queryBuilder().where(StudentDao.Properties.StuName.eq("贺da宝")).build().unique();
                if (student != null) {
                    student.setStuName("I Love You");
                    stuDao.update(student);
                }
                Toast.makeText(self, "更新成功~", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
