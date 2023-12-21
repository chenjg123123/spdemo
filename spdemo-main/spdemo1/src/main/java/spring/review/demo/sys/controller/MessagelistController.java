package spring.review.demo.sys.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.ui.Model;
import org.springframework.util.ConcurrentReferenceHashMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import spring.review.demo.sys.entity.Messagelist;
import spring.review.demo.sys.entity.Messages;
import spring.review.demo.sys.service.IMessagelistService;
import spring.review.demo.sys.service.IMessagesService;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author abc
 * @since 2023-12-12
 */
@ServerEndpoint("/websocket/{userid}")
@RestController
@Slf4j
public class MessagelistController {
    /**
     * 设置一次性存储数据的list的长度为固定值，每当list的长度达到固定值时，向数据库存储一次
     */
//    private static final Integer LIST_SIZE = 3;

    /**
     * 设置在线人数为静态变量
     */
//    public static int onlineNumber = 0;

    private static IMessagelistService messagelistService;

    private static  IMessagesService messagesService;

    /**
     * 新建list集合存储数据
     */
//    private static ArrayList<Messagelist> MessageList = new ArrayList<>();

    /**
     * map(username,websocket)作为对象添加到集合中
     */
    private static Map<String, MessagelistController> clients = new ConcurrentHashMap<String, MessagelistController>();

    /**
     * session会话
     */
    private Session session;
    /**
     * 用户id
     */
    private String userid;

    /**
     * 会话窗口
     *
     */
    private static Map<Integer,Integer[]> MessageClient = new ConcurrentHashMap<>();

    //获取当前在线人数
//    public static synchronized int getOnlineCount() {
//        return onlineNumber;
//    }

    @Autowired
    public void setOgLocationService(IMessagelistService userMessageService) {
        MessagelistController.messagelistService = userMessageService;
    }
    @Autowired
    public void setOgLocationService1(IMessagesService userMessageService) {
        MessagelistController.messagesService = userMessageService;
    }
    @RequestMapping("/sys/messagelist")
    public String webSocket(Model model) {

        //根据时间随机定义名称
//        String name = "游客：";
//        String datename = new SimpleDateFormat("msss").format(new Date());
//        name = name + datename;

        //websock链接地址+游客名-->  项目中请定义在配置文件 -->或直接读取服务器，ip 端口
        String path = "ws://local:8080/websocket/";
        model.addAttribute("path", path);
        model.addAttribute("userid", this.userid);
        return "socket";
    }
    @OnOpen
    public void onOpen(@PathParam("userid") String userid, Session session) throws IOException{

        //每打开一个新的窗口，在线人数onlineNumber++
//        onlineNumber++;
        //把新用户名赋给变量
        this.userid = userid;
        //把新用户的 session 信息赋给变量
        this.session = session;
        //输出 websocket 信息
//        this.session.getBasicRemote().sendText("error");
        log.info("现在来连接的客户id：" + session.getId() + "用户名：" + userid);
//        log.info("有新连接加入！ 当前在线人数" );
//        try {
            //把自己的信息加入到map当中去，this=当前类（把当前类作为对象保存起来）
            clients.put(userid, this);
//            //获得所有的用户lists
//            Set<String> lists = clients.keySet();
            // 发送全体信息（新用户上线信息）

//            //messageType 1代表上线 2代表下线 3代表在线名单 4代表普通消息
//            Map<String, Object> map1 = new HashMap(100);
//            //  把所有用户列表
//            map1.put("onlineUsers", lists);
//            //  返回上线状态
//            map1.put("messageType", 1);
//            //  返回用户名
//            map1.put("username", username);
//            //  返回在线人数
//            map1.put("number", onlineNumber);
//
//            //  发送全体信息（用户上线信息）
//            sendMessageAll(JSON.toJSONString(map1), username);

//            // 给自己发一条消息：告诉自己现在都有谁在线
//            Map<String, Object> map2 = new HashMap(100);
//            //messageType 1代表上线 2代表下线 3代表在线名单 4代表普通消息
//            map2.put("messageType", 3);
//            //把所有用户放入map2
//            map2.put("onlineUsers", lists);
//            //返回在线人数
//            map2.put("number", onlineNumber);
//            Messagelist messagelist = new Messagelist();
//
//            // 消息发送指定人（所有的在线用户信息）
//            sendMessageToUser();
//        }
//        catch (IOException e) {
//            log.info(userid + "上线的时候通知所有人发生了错误");
//        }
    }
    @OnClose
    public void onClose() throws IOException{
//        //每关闭一个新的窗口，在线人数onlineNumber--
//        onlineNumber--;
        //从所有在线用户的map中去除下线用户
        clients.remove(userid);
//        try {
//            //messageType 1代表上线 2代表下线 3代表在线名单  4代表普通消息
//            Map<String, Object> map1 = new HashMap(100);
//            map1.put("messageType", 2);
//            //所有在线用户
//            map1.put("onlineUsers", clients.keySet());
//            //下线用户的用户名
//            map1.put("userid", userid);
//            //返回在线人数
//            map1.put("number", onlineNumber);
//            //发送信息，所有人，通知谁下线了
//            sendMessageAll(JSON.toJSONString(map1), userid);
//            //关闭连接前，判断list集合是否有数据，如果有，批量保存到数据库
//            if (MessageList.size() > 0) {
//                messagelistService.saveBatch(MessageList);
//            }
//        this.session.getBasicRemote().sendText("error");
            log.info("有人关闭了");

//        } catch (IOException e) {
//            log.info(userid + "下线的时候通知所有人发生了错误");
//        }
//        log.info("有连接关闭！ 当前在线人数" + onlineNumber);
    }
    @OnError
    public void onError(Session session, Throwable error) throws IOException{
        log.info("服务端发生了错误" + error.getMessage());
//        this.session.getBasicRemote().sendText("error");
        //error.printStackTrace();
    }
    /**
     * 监听消息（收到客户端的消息立即执行）
     *
     * @param message 消息
     * @param session 会话
     */
    @OnMessage
    public void onMessage(String message, Session session) {
        try {
            log.info("来自客户端消息：" + message + "客户端的id是：" + session.getId());
            //用户发送的信息
            com.alibaba.fastjson.JSONObject jsonObject = JSON.parseObject(message);
            System.out.println(jsonObject);
            //发送的内容
            String textMessage = jsonObject.getString("content");
            //发送人
            Integer fromusername = Integer.parseInt(jsonObject.getString("senderid"));
            //接收人  to=all 发送消息给所有人 || to= !all   to == 用户名
            Integer tousername = Integer.parseInt(jsonObject.getString("messageid"));

            //新建message对象
            Messagelist messagelist = new Messagelist();

            //设置发送者的username
            messagelist.setSenderid(fromusername);
            //设置发送的信息
            messagelist.setContent(textMessage);
            //设置发送时间
            messagelist.setCreateTime(LocalDateTime.now() );
            //设置聊天号
            messagelist.setMessageid(tousername);
            //设置类型
            messagelist.setIscompany("F");
//            //判断接收者
//            if (tousername.equals("All")) {
//                message1.setTousername("All");
//            } else {
//                message1.setTousername(tousername);
//            }
//            //批量保存信息
//            //将每条记录添加到list集合中
//            MessageList.add(message1);
//            //判断list集合长度
//            if (MessageList.size() == LIST_SIZE) {
//                userMessageService.saveBatch(MessageList);
//                //清空集合
//                MessageList.clear();
//            }
            sendMessageToUser(messagelist);

//            //发送消息  -- messageType 1代表上线 2代表下线 3代表在线名单  4代表消息
//            Map<String, Object> map1 = new HashMap(100);
//            map1.put("messageType", 4);
//            map1.put("textMessage", textMessage);
//            map1.put("fromusername", fromusername);
//            if (tousername.equals("All")) {
//                //消息发送所有人（同步）
//                map1.put("tousername", "所有人");
//                sendMessageAll(JSON.toJSONString(map1), fromusername);
//            } else {
//                //消息发送指定人（同步）
//                map1.put("tousername", tousername);
//                sendMessageTo(JSON.toJSONString(map1), tousername);
//            }
        } catch (Exception e) {
            log.info(e.getMessage());
        }
    }

    private void sendMessageToUser(Messagelist messagelist) throws IOException{
            log.info("send");
            if(!MessageClient.containsKey(messagelist.getMessageid().toString())){
                log.info("send1");
                LambdaQueryWrapper<Messages> messagesLambdaQueryWrapper = new LambdaQueryWrapper<>();
                messagesLambdaQueryWrapper.eq(Messages::getMassageId,messagelist.getMessageid());
                Messages one =  messagesService.getOne(messagesLambdaQueryWrapper);
                System.out.println(one);
                Integer[] userid = new Integer[2];
                userid[0] = one.getSenderId();
                userid[1] = one.getReceiverCompanyId();
                System.out.println(userid[0]);
                System.out.println(userid[1]);
                MessageClient.put(messagelist.getMessageid(),userid);
            }

            Integer[] userid =  MessageClient.get(messagelist.getMessageid());
            if(clients.containsKey(userid[0].toString()) && clients.containsKey(userid[1].toString())) {
                log.info("send2");
                clients.get(userid[0].toString()).session.getBasicRemote().sendText(JSON.toJSONString(messagelist));
                clients.get(userid[1].toString()).session.getBasicRemote().sendText(JSON.toJSONString(messagelist));
            } else {
                log.info("send3");
            log.info("用户 "  + " 不在线");
            clients.get(messagelist.getSenderid().toString()).session.getBasicRemote().sendText(JSON.toJSONString(messagelist));
        }
        messagelistService.save(messagelist);
    }


}
