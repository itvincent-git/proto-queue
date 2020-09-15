package net.protoqueue;

import android.support.annotation.NonNull;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/**
 * 提供返回PortTransformer实现类的方法
 * Created by zhongyongsheng on 2018/4/13.
 */
public class ProtoQueueBuilder<T extends ProtoQueue> {
    private static final String IMPL_SUFFIX = "_Impl";
    private final Class<T> mTransformerClass;
    private final ProtoSender mSender;
    private Function1<Object, Unit> mIntercepter;

    private void setIntercepter(Function1<Object, Unit> intercepter) {
        mIntercepter = intercepter;
    }

    public ProtoQueueBuilder(Class<T> cls, ProtoSender sender) {
        mTransformerClass = cls;
        mSender = sender;
    }

    public static <T extends ProtoQueue> ProtoQueueBuilder<T> newBuilder(
        @NonNull Class<T> cls, @NonNull ProtoSender sender) {
        return new ProtoQueueBuilder<>(cls, sender);
    }

    public T build() {
        T implementation = getGeneratedImplementation(mTransformerClass, IMPL_SUFFIX);
        implementation.init(mSender, mIntercepter);
        return implementation;
    }

    @NonNull
    static <T, C> T getGeneratedImplementation(Class<C> cls, String suffix) {
        final String fullPackage = cls.getPackage().getName();
        String name = cls.getCanonicalName();
        final String postPackageName = fullPackage.isEmpty()
            ? name : (name.substring(fullPackage.length() + 1));
        final String implName = postPackageName.replace('.', '_') + suffix;
        try {
            @SuppressWarnings("unchecked") final Class<T> aClass = (Class<T>) Class.forName(
                fullPackage.isEmpty() ? implName : fullPackage + "." + implName);
            return aClass.newInstance();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(
                "cannot find implementation for " + cls.getCanonicalName() + ". " + implName + " does not exist");
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Cannot access the constructor" + cls.getCanonicalName());
        } catch (InstantiationException e) {
            throw new RuntimeException("Failed to create an instance of " + cls.getCanonicalName());
        }
    }
}
