package edu.mit.cci.roma.excel.responsesurfaces;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * User: jintrone
 * Date: 2/25/11
 * Time: 7:42 AM
 */
public class SimpleResponseSurfaceTest {


    Polynomial p = new Polynomial(new double[]{4, 5});
    SliceSegment<Float> s1 = new SliceSegment<Float>(3f, 4f, 100, p);
    SliceSegment<Float> s2 = new SliceSegment<Float>(4f, 5f, 103, p);

    SliceSegment<Float> s3 = new SliceSegment<Float>(1f, 2f, 1, p);
    SliceSegment<Float> s4 = new SliceSegment<Float>(3f, 6f, 2, p);

    SliceSegment<Float> s5 = new SliceSegment<Float>(1f, 2f, 100, p);
    SliceSegment<Float> s6 = new SliceSegment<Float>(3f, 6f, 103, p);


    Slice<Float> sl1 = new Slice<Float>();

    Slice<Float> sl2 = new Slice<Float>();

    Slice<Float> sl3 = new Slice<Float>();


    {
        sl1.add(s2);
        sl1.add(s1);
        sl2.add(s3);
        sl2.add(s4);
        sl3.add(s5);
        sl3.add(s6);
    }

    @Test
    public void testInvalidCheck() throws Exception {
        SimpleResponseSurface<Float> rs = new SimpleResponseSurface<Float>();
        rs.addSlice(sl1);
        try {
            rs.addSlice(sl2);
            Assert.fail("Should disallow adding slices with different indices");
        } catch (IllegalArgumentException ex) {

        }
    }

    @Test
    public void testReset() throws Exception {
        SimpleResponseSurface<Float> rs = new SimpleResponseSurface<Float>();
        rs.addSlice(sl1);
        rs.removeSlice(sl1);
        rs.addSlice(sl2);

    }

    @Test
    public void testOrdering() throws Exception {
        SimpleResponseSurface<Float> rs = new SimpleResponseSurface<Float>();
        rs.addSlice(sl3);
        rs.addSlice(sl1);

        Assert.assertTrue(rs.getSlices().indexOf(sl1)<rs.getSlices().indexOf(sl3));
    }

    @Test
    public void testCrosswiseGet() throws Exception {
        SimpleResponseSurface<Float> rs = new SimpleResponseSurface<Float>();
        rs.addSlice(sl3);
        rs.addSlice(sl1);

        Assert.assertNull(rs.getAtIndex(1));

        List<SliceSegment<Float>> segs = rs.getAtIndex(100);
        Assert.assertTrue(segs.size()==2);
        Assert.assertSame(segs.get(0),s1);
        Assert.assertSame(segs.get(1),s5);

    }

}
