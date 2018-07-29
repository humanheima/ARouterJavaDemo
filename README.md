## learn ARouter

应用内跳转传递参数
```
 ARouter.getInstance()
                        .build("/app/third_activity")
                        .withString("key0","value0")
                        .withInt("key1",100)
                        .navigation();
```
ThirdActivity
```
@Route(path = "/app/third_activity")
public class ThirdActivity extends AppCompatActivity {

    private static final String TAG = "ThirdActivity";

    /**
     * 注解字段
     */
    @Autowired
    String key0;
    @Autowired
    int key1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //inject
        ARouter.getInstance().inject(this);
        setContentView(R.layout.activity_third);
        Log.d(TAG, "onCreate: key0=" + key0 + ",key1=" + key1);
    }
}
```
应用内跳转要求返回结果
```
ARouter.getInstance().build("/app/second_activity").navigation(this, 666);

```