package net.frank.demos.cassandra.app;

import net.frank.demos.cassandra.dao.BuyerDao;
import net.frank.demos.cassandra.dao.ProductDao;
import net.frank.demos.cassandra.dao.SellerDao;
import net.frank.demos.cassandra.dao.impl.BuyerDaoImpl;
import net.frank.demos.cassandra.dao.impl.ProductDaoImpl;
import net.frank.demos.cassandra.dao.impl.SellerDaoImpl;
import net.frank.demos.cassandra.model.Buyer;
import net.frank.demos.cassandra.model.Comment;
import net.frank.demos.cassandra.model.Product;
import net.frank.demos.cassandra.model.Seller;
import org.safehaus.uuid.UUID;
import org.safehaus.uuid.UUIDGenerator;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.List;

public class App {

    private static final String HOST = "localhost";
    private static final int PORT = 9160;

    static String getPropertyString(Object entityName)
        throws Exception{
        Class<?> c = entityName.getClass();
        Field[] field = c.getDeclaredFields();
        StringBuffer sb = new StringBuffer();

        for(Field f : field){
            if((f.getModifiers() & Modifier.STATIC) != 0 ){
                continue;
            }
            sb.append(f.getName());
            sb.append(" : ");
            sb.append(invokeMethod(entityName, f.getName(),null));
            sb.append("\n");
        }

        return sb.toString();
    }

    static Object invokeMethod(Object owner, String methodName, Object[] args)
        throws Exception{
        Class<?> ownerClass = owner.getClass();
        methodName = methodName.substring(0,1).toUpperCase() + methodName.substring(1);
        Method method = null;
        try{
            method = ownerClass.getMethod("get" + methodName);
        }catch (Exception e){

        }
        return method.invoke(owner,args);
    }

    public static void main(String[] args){
        /***
        BuyerDao buyerDao = new BuyerDaoImpl(HOST,PORT);
        {
            Buyer buyer = new Buyer();
            buyer.setUserName("aaron");
            buyer.setName("郭鹏");
            buyer.setAddress("China Hangzhou");
            buyer.setAge(26);
            buyer.setSex("male");

            try{
                buyerDao.insertBuyer(buyer);
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        {
            Buyer buyer = new Buyer();
            buyer.setUserName("lily");
            buyer.setName("李娜");
            buyer.setAddress("China 大连");
            buyer.setAge(23);
            buyer.setSex("female");

            try{
                buyerDao.insertBuyer(buyer);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        try {
            Buyer aaron = buyerDao.getBuyer("aaron");
            System.out.println(getPropertyString(aaron));
        }catch (Exception e){
            e.printStackTrace();
        }

        SellerDao sellerDao = new SellerDaoImpl(HOST,PORT);

        {
            Seller seller = new Seller();
            seller.setUserName("sportSeller");
            seller.setName("体育用品专卖");
            seller.setAddress("China Wuhan");
            seller.setAge(30);
            seller.setSex("male");

            try{
                sellerDao.insertSeller(seller);
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        {
            Seller seller = new Seller();
            seller.setUserName("seller2");
            seller.setName("美丽服装");
            seller.setAddress("China Beijing");
            seller.setAge(37);
            seller.setSex("male");

            try{
                sellerDao.insertSeller(seller);
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        try{
            Seller sportSeller = sellerDao.getSeller("sportSeller");
            System.out.println(getPropertyString(sportSeller));
        }catch (Exception e){
            e.printStackTrace();
        }

        ProductDao productDao = new ProductDaoImpl(HOST,PORT);
        UUID footballUuid;
        UUID basketballUuid;
        {
            Product product = new Product();
            product.setDesc("白色真皮足球");
            product.setSellerUserName("sportSeller");
            product.setName("Football");
            product.setPrice(98.8);
            product.setUuid(UUIDGenerator.getInstance().generateTimeBasedUUID());
            try{
                productDao.insertProduct(product);
            }catch (Exception e){
                e.printStackTrace();
            }
            footballUuid = product.getUuid();
        }

        {
            Product product = new Product();
            product.setDesc("橡胶篮球");
            product.setSellerUserName("sportSeller");
            product.setName("Basketball");
            product.setPrice(29.8);
            product.setUuid(UUIDGenerator.getInstance().generateTimeBasedUUID());
            try{
                productDao.insertProduct(product);
            }catch (Exception e){
                e.printStackTrace();
            }
            basketballUuid = product.getUuid();
        }

        try{
            Product football = productDao.getProduct(footballUuid);
            System.out.println(getPropertyString(football));
        }catch (Exception e){
            e.printStackTrace();
        }

        try{
            productDao.insertProductCategory("Sports", footballUuid);
            productDao.insertProductCategory("Sports", basketballUuid);
        }catch (Exception e){
            e.printStackTrace();
        }
        ***/

        ProductDao productDao = new ProductDaoImpl(HOST,PORT);
        try{
            List<Product> products = productDao.
                    getTopCategoryProducts("Sports",2);
            for(Product product:products){
                System.out.println(getPropertyString(product));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        String basketballUuid = "748d3f06-2f89-11ea-bf7b-3b0bd9b44a41";
        String footballUuid = "748ca2c5-2f89-11ea-bf7b-3b0bd9b44a41";

        {
            Comment comment = new Comment();
            comment.setUuid(UUIDGenerator.getInstance().generateTimeBasedUUID());
            comment.setCommentUserName("aaron");
            comment.setContent("good product");
            try {
                productDao.insertComment(new UUID(basketballUuid), comment);
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        {
            Comment comment = new Comment();
            comment.setUuid(UUIDGenerator.getInstance().generateTimeBasedUUID());
            comment.setCommentUserName("aaron");
            comment.setContent("送货速度快");
            try {
                productDao.insertComment(new UUID(basketballUuid), comment);
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        {
            Comment comment = new Comment();
            comment.setUuid(UUIDGenerator.getInstance().generateTimeBasedUUID());
            comment.setCommentUserName("lily");
            comment.setContent("弟弟很喜欢这个礼物");
            try {
                productDao.insertComment(new UUID(basketballUuid), comment);
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        try{
            List<Comment> comments = productDao.getTopProductComments(
                    new UUID(basketballUuid),2);
            for(Comment comment : comments){
                System.out.println(getPropertyString(comment));
            }
        }catch (Exception e){

        }


    }


}
