import com.github.rmannibucau.asm6.util.SomeSpi;
import com.github.rmannibucau.asm6.util.SomeSpiImpl;

module com.github.rmannibucau.asm6 {
    // TODO by the shade plugin
    // exports com.github.rmannibucau.asm6[.tree|.commons|.signature|''];

    exports com.github.rmannibucau.asm6.util;

    // TODO: relocate
    requires org.objectweb.asm;

    // to keep otherwise ServiceLoader will not work as expected
    uses SomeSpi;
    provides SomeSpi with SomeSpiImpl;
}
