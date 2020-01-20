package edu.just.mqtt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.eclipse.paho.android.service.MqttAndroidClient;
import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.IMqttMessageListener;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttCallbackExtended;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class MqttActivity extends AppCompatActivity {

    MqttAndroidClient mqttAndroidClient;

    final String serverUri = "tcp://192.168.0.106:1883";
    String clientId = "hqf";
    final String subscriptionTopic = "/Subscription/Topic";
    final String publishTopic = "/Publish/Topic";//推送主题
    final String publishMessage = "Hello World!";//推送信息

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mqtt);
        //新建client实例
        clientId = clientId + System.currentTimeMillis();
        mqttAndroidClient = new MqttAndroidClient(getApplicationContext(), serverUri, clientId);
        //设置回调函数
        mqttAndroidClient.setCallback(new MqttCallbackExtended() {
            @Override
            public void connectComplete(boolean reconnect, String serverURI) {
            }

            @Override
            public void connectionLost(Throwable cause) {
            }

            @Override
            public void messageArrived(String topic, MqttMessage message) throws Exception {
                makeToast(new String(message.getPayload()));
            }

            @Override
            public void deliveryComplete(IMqttDeliveryToken token) {
            }
        });
        //连接设置，是否重连，是否清理session
        MqttConnectOptions mqttConnectOptions = new MqttConnectOptions();
        mqttConnectOptions.setAutomaticReconnect(true);
        mqttConnectOptions.setCleanSession(false);

        try {
            //连接mqtt服务器
            mqttAndroidClient.connect(mqttConnectOptions, null, new IMqttActionListener() {
                @Override
                public void onSuccess(IMqttToken asyncActionToken) {
                    makeToast("连接成功");
                    //订阅topic
                    subscribeToTopic();
                }

                @Override
                public void onFailure(IMqttToken asyncActionToken, Throwable exception) {
                    makeToast("连接失败");
                }
            });
        } catch (MqttException ex) {
            ex.printStackTrace();
        }

        //按键发布消息
        Button button1 = (findViewById(R.id.button1));
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                publishMessage();
            }
        });
    }

    public void subscribeToTopic() {
        try {
            //开始订阅
            mqttAndroidClient.subscribe(subscriptionTopic, 0, null, new IMqttActionListener() {
                @Override
                public void onSuccess(IMqttToken asyncActionToken) {
                    makeToast("成功订阅到" + subscriptionTopic);
                }

                @Override
                public void onFailure(IMqttToken asyncActionToken, Throwable exception) {
                    makeToast("订阅失败" + subscriptionTopic);
                }
            });

        } catch (MqttException ex) {
            ex.printStackTrace();
        }
    }
    /*推送消息*/
    public void publishMessage(){

        try {
            MqttMessage message = new MqttMessage();
            message.setPayload(publishMessage.getBytes());
            mqttAndroidClient.publish(publishTopic, message);
            //addToHistory("Message Published");
            if(!mqttAndroidClient.isConnected()){
                //addToHistory(mqttAndroidClient.getBufferedMessageCount() + " messages in buffer.");
                makeToast("推送消息失败");
            }
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }
    private void makeToast(String str) {
        Toast.makeText(MqttActivity.this, str, Toast.LENGTH_LONG).show();
        TextView textView = (TextView)findViewById(R.id.textView1);
        textView.setText(str);
    }

}
