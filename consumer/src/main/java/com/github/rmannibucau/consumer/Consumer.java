package com.github.rmannibucau.consumer;

import com.github.rmannibucau.asm6.ClassVisitor;
import com.github.rmannibucau.asm6.util.SomeSpi;
import com.github.rmannibucau.asm6.util.Visit;

import java.util.ServiceLoader;

import static com.github.rmannibucau.asm6.Opcodes.ASM6;

public class Consumer {
    public static void main(String[] args) {
        System.out.println(ServiceLoader.load(SomeSpi.class).iterator().next()); // must not fail
        Visit.visit(Thread.currentThread().getContextClassLoader()
                        .getResourceAsStream(Consumer.class.getName().replace('.', '/') + ".class"),
                new ClassVisitor(ASM6) {
                    @Override
                    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
                        super.visit(version, access, name, signature, superName, interfaces);
                        System.out.println("Visited: " + name);
                    }
                });
    }
}
