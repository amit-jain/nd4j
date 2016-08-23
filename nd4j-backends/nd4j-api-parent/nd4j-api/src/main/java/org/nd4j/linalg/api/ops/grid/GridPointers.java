package org.nd4j.linalg.api.ops.grid;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bytedeco.javacpp.Pointer;
import org.nd4j.linalg.api.buffer.DataBuffer;
import org.nd4j.linalg.api.ops.*;

/**
 * POJO describing OP
 * @author raver119@gmail.com
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GridPointers {
    private Op.Type type;
    private int opNum;
    private DataBuffer.Type dtype;

    // data buffers
    private Pointer x;
    private Pointer y;
    private Pointer z;

    // strides
    private int xStride = -1;
    private int yStride = -1;
    private int zStride = -1;

    private int xLength = 0;
    private int yLength = 0;
    private int zLength = 0;

    // shapeInfo pointers
    private Pointer xShapeInfo;
    private Pointer yShapeInfo;
    private Pointer zShapeInfo;

    // dimension-related data
    private Pointer dimensions;
    private int dimensionsLength = 0;

    // TAD shapes
    private Pointer tadShape;
    private Pointer tadOffsets;

    // Op extraArgs
    private Pointer extraArgs;

    public GridPointers(Op op, int... dimensions) {
        this.type = BaseOp.getOpType(op);
        this.dtype = op.x().data().dataType();
        this.opNum = op.opNum();

        this.xLength = op.x().length();
        this.zLength = op.z().length();

        this.xStride = op.x().elementWiseStride();
        this.zStride = op.z().elementWiseStride();
        if (op.y() != null) {
            this.yStride = op.y().elementWiseStride();
            this.yLength = op.y().length();
        }

        if (dimensions != null)
            this.dimensionsLength = dimensions.length;
    }
}