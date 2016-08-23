package org.nd4j.linalg.api.ops;

import org.nd4j.linalg.api.buffer.DataBuffer;
import org.nd4j.linalg.api.ops.grid.GridDescriptor;
import org.nd4j.linalg.api.ops.grid.GridPointers;

/**
 * MetaOp is special op, that contains multiple ops
 *
 * @author raver119@gmail.com
 */
public interface MetaOp extends GridOp {
    Op getFirstOp();

    Op getSecondOp();

    void setFirstPointers(GridPointers pointers);

    void setSecondPointers(GridPointers pointers);
}