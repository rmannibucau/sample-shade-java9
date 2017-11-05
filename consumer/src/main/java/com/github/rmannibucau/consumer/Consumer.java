package com.github.rmannibucau.consumer;

import com.github.rmannibucau.asm6.ClassVisitor;
import com.github.rmannibucau.asm6.util.Visit;

public class Consumer {
    public static void main(String[] args) {
        Visit.visit(Thread.currentThread().getContextClassLoader()
                        .getResourceAsStream(Consumer.class.getName().replace('.', '/') + ".class"),
                new ClassVisitor() {
                    @Override
                    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
                        super.visit(version, access, name, signature, superName, interfaces);
                        System.out.println("Visited: " + name);
                    }
                });
    }
}
