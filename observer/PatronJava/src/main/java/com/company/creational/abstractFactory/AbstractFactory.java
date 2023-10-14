package com.company.creational.abstractFactory;

public interface AbstractFactory<T> {
    T create(String type);
}
