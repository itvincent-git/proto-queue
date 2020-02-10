package com.google.protobuf.nano;

import java.io.IOException;

/**
 * @author linmin1 on 2020-02-10.
 */
public interface DescriptorProtos {
    public static class ServiceOptions extends ExtendableMessageNano<ServiceOptions> {
        @Override
        public MessageNano mergeFrom(CodedInputByteBufferNano input) throws IOException {
            return null;
        }
    }

}
