package com.gupaoedu.vip.pattern.builder.general;

import lombok.Data;

/**
 * Created by Tom
 */
public class Client {
    public static void main(String[] args) {
        IBuilder builder = new ConcreteBuilder();

        System.out.println(builder.build());

    }

//    @Data
    static class Product {

        private String name;

        @Override
        public String toString() {
            return "Product{" +
                    "name='" + name + '\'' +
                    '}';
        }

    }

    interface IBuilder {
        Product build();
    }

    static class ConcreteBuilder implements IBuilder {

        private Product product = new Product();

        public Product build() {
            return product;
        }
    }

}
