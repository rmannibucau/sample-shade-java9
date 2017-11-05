package com.github.rmannibucau.asm6.util;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;

import java.io.IOException;
import java.io.InputStream;

public class Visit {
    public static void visit(final InputStream source, final ClassVisitor visitor) {
        try {
            final ClassReader reader = new ClassReader(source);
            reader.accept(visitor, ClassReader.SKIP_DEBUG);
        } catch (final IOException e) {
            throw new IllegalStateException(e);
        }
    }
}
