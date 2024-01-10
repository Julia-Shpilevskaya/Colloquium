import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class CalculationEngineTest {

    @Mock
    private DBGateForCalculations dbGateMock;

    @Mock
    private DBConnection dbConnectionMock;

    private CalculationEngine calculationEngine;

    @Before
    public void setUp() {

        MockitoAnnotations.initMocks(this);

        calculationEngine = new CalculationEngine(dbGateMock);

        Mockito.when(dbGateMock.getDBConnection()).thenReturn(dbConnectionMock);
    }

    @Test
    public void testCalc() {

        Mockito.when(dbConnectionMock.executeQuery(Mockito.anyString())).thenReturn();

    }

    @Test
    public void testProcess() {

        Mockito.when(dbConnectionMock.executeQuery(Mockito.anyString())).thenReturn();

    }
}
