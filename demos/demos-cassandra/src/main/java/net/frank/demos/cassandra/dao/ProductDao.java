package net.frank.demos.cassandra.dao;

import net.frank.demos.cassandra.model.Comment;
import net.frank.demos.cassandra.model.Product;
import org.safehaus.uuid.UUID;

import java.util.List;

public interface ProductDao {

    void insertProduct(Product product) throws Exception;

    void insertProductCategory(String category, UUID productUUID) throws Exception;

    void insertComment(UUID productUUID, Comment comment) throws Exception;

    Product getProduct(UUID productUUID) throws Exception;

    List<Product> getTopCategoryProducts(String category, int topNum) throws Exception;

    List<Comment> getTopProductComments(UUID productUUID, int topNum) throws Exception;
}
