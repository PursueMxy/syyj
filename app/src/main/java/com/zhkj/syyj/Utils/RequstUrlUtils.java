package com.zhkj.syyj.Utils;

public class RequstUrlUtils {
    public static class URL{
        //请求头
        public static  String HOST="http://syapi.kuaishanghd.com";
        //测试
//        public static  String HOST="http://192.168.0.8:99/index";
        //注册
        public static String Logon=HOST+"/user/reg";

        //上传图片
        public static String Upload=HOST+"/api/upload";

        //检测手机号是否已使用
        public static String IssetMobile=HOST+"/api/issetMobile";

        //发送短信( 1 注册/绑定新手机号 2 找回密码 6 验证原手机号)
        public static String SendCode=HOST+"/api/sendCode";

        //模拟验证码
        public static String GetCode=HOST+"/api/getCode";

        //手机登录
        public static String Login=HOST+"/user/login";

        //个人中心
        public static String Index=HOST+"/user/index";

        //修改个人信息
        public static String UserInfo=HOST+"/user/userInfo";

        //个人信息
        public static String User=HOST+"/user/user";

        //商城分类
        public static String CategoryList=HOST+"/goods/categoryList";

        //找回密码
        public static String ResetPass=HOST+"/user/resetPass";

        //修改密码
        public static String UpdatePass=HOST+"/user/updatePass";

        //更换手机号
        public static String updateMobile=HOST+"/user/updateMobile";

        //验证验证码
        public static String CheckCode=HOST+"/user/checkCode";

        //系统/服务消息列表
        public static String MessageNoticeList=HOST+"/user/messageNoticeList";

        //消息详情
        public static String Message_notice_info=HOST+"user/message_notice_info";

        //修改个人信息
        public static String SaveUserInfo=HOST+"/user/saveUserInfo";

        //任务分类
        public static String TaskCategory=HOST+"/task/taskCategory";

        //任务列表
        public static String TaskList=HOST+"/task/taskList";

        //已完成任务
        public static String DoneList=HOST+"/task/doneList";

        //首页
        public static  String HomeIndex=HOST+"/index/index";

        //资讯精选
        public static  String NewsList=HOST+"/index/newsList";

        //资讯详情
        public static String NewsDetail=HOST+"/index/newsDetail";

        //我的余额
        public static  String Balance=HOST+"/user/balance";

        //我的会员
        public static String UserLevel=HOST+"/user/level";

        //收货地址列表
        public static String AddressList=HOST+"/user/addressList";

        //新增收货地址
        public static String SaveAddress=HOST+"/user/saveAddress";

        //删除收货地址
        public static String DelAddress=HOST+"/user/delAddress";

        //获取默认地址
        public static String GetDefaultAddress=HOST+"/user/getDefaultAddress";

        //设置提醒
        public static String TaskSetRemind=HOST+"/task/setRemind";

        //商品详情
        public static String GoodsInfo=HOST+"/goods/goodsInfo";

        //商城列表
        public static  String GoodsList=HOST+"/goods/goodsList";

        //加入购物车
        public static String CartAdd=HOST+"/cart/add";

        //购物车/立即购买第二步确定页面
        public static  String CartAdd2=HOST+"/cart/cart2";

        //提交订单支付
        public static String CartCart3=HOST+"/cart/cart3";

        //获取订单列表
        public static String OrderList=HOST+"/order/orderList";

        //积分明细
        public static String IntegralRecord=HOST+"/user/integralRecord";

        //订单详情
        public static String OrderDetail=HOST+"/order/orderDetail";

        //收藏/取消
        public static String GoodsCollectGoods=HOST+"/goods/collectGoods";

        //收藏列表取消收藏
        public static String CancelCollect=HOST+"/user/cancelCollect";

        //我的收藏
        public static String CollectList=HOST+"/user/collectList";

        //购物车列表
        public static String CartIndex=HOST+"/cart/index";

        //优惠券列表
        public static String UserCouponList=HOST+"/coupon/userCouponList";

        //优惠券详情
        public static String CouponDetail=HOST+"/coupon/detail";

        //积分商城分类
        public static String IntegralCategory=HOST+"/goods/integralCategory";

        //积分商城列表
        public static String IntegralMall=HOST+"/goods/integralMall";

        //积分商城详情
        public static String IntegraDetail=HOST+"/goods/integraDetail";

        //积分立即兑换
        public static String BuyIntegralGoods=HOST+"/cart/buyIntegralGoods";

        //积分订单提交
        public static String Integral=HOST+"/cart/integral";

        //购物车商品数量加减
        public static String ChangeNum=HOST+"/cart/changeNum";

        // 更新购物车，并返回计算结果
        public static String AsyncUpdateCart=HOST+"/cart/asyncUpdateCart";

        //开始任务
        public static String StartTask=HOST+"/task/startTask";

        //删除购物车
        public static String CartDelete=HOST+"/cart/delete";

        //商品评论
        public static String GoodsComment=HOST+"/goods/comment";

        // 取消订单 订单未支付
        public static String CancelOrder=HOST+"/order/cancel_order";

        //立即付款
        public static String OrderPay=HOST+"/order/pay";

        //确认收货
        public static  String OrderConfirm=HOST+"/order/order_confirm";

        //再次购买
        public static String OrderOneMore=HOST+"/order/oneMore";

        //删除订单
        public static String OrderDel_order=HOST+"/order/del_order";

        //物流详情
        public static String OrderExpress=HOST+"/order/express";

        //申请取消订单 已支付未发货
        public static String RecordRefundOrder=HOST+"record_refund_order";

        //发表评价
        public static String OrderAdd_comment=HOST+"/order/add_comment";

    }
}
