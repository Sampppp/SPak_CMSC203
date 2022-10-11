import junit.framework.TestCase;

public class GradeBookTest extends TestCase {

	GradeBook g1;
	GradeBook g2;
	protected void setUp() throws Exception {
		super.setUp();
		g1 = new GradeBook(5);
		g2 = new GradeBook(5);
		
		g1.addScore(1);
		g1.addScore(2);
		g2.addScore(3);
		g2.addScore(4);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		g1 = null;
		g2 = null;
	}

	public void testAddScore() {
		assertTrue(g1.addScore(3));
	}

	public void testSum() {
		assertEquals(3, g1.sum(), .0001);
	}

	public void testMinimum() {
		assertEquals(1, g1.minimum(), .001);
	}

	public void testFinalScore() {

		assertEquals(2 ,g1.finalScore(), .001);
		
	}

	public void testGetScoreSize() {
		assertEquals(2, g1.getScoreSize(), .001);
	}

	public void testToString() {
		assertEquals("1.0 2.0 ", g1.toString());
	}

}
