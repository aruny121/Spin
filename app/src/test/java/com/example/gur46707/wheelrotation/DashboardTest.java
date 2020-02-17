package com.example.gur46707.wheelrotation;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

@RunWith(PowerMockRunner.class)
@PrepareForTest({Dashboard.class,Button.class})

public class DashboardTest {
    @Mock
    Dashboard mockUserService;
    @Mock
    private Button bt;
    @Mock
    private ImageView img;
    @Mock
    private TextView tc;

    @Before
    public void setUp() throws Exception{
        mockUserService = spy(Dashboard.class);
        MockitoAnnotations.initMocks(this);

        bt = Mockito.mock(Button.class);
        doReturn(bt).when(mockUserService).findViewById(R.id.speedtest);

    }
    @Test
    public void setUpUI() throws Exception{
         tc = Mockito.mock(TextView.class);
         bt = Mockito.mock(Button.class);
         img = Mockito.mock(ImageView.class);
        doReturn(tc).when(mockUserService).findViewById(anyInt());
        doReturn(bt).when(mockUserService).findViewById(R.id.speedtest);
        doReturn(img).when(mockUserService).findViewById(R.id.wheelImg);

    }


    @Test
    public void handleSnackbar() throws Exception{
        Button bt = Mockito.mock(Button.class);
        doReturn(bt).when(mockUserService).findViewById(anyInt());
        mockUserService.handleSnackbar("HELLO");
        mockUserService.handleSnackbar(Constants.FETCHING);
        mockUserService.handleSnackbar(Constants.UPDATED);

    }


    @Test
    public void setMeter() throws Exception{
        mockUserService.setMeter(10);
    }


    @Test
    public void onApiResult() throws Exception{
        mockUserService.onApiResult(10,"hello");
        mockUserService.onApiResult(10,Constants.FAIL_API);
        mockUserService.onApiResult(10,Constants.SUCCESS_API);

    }








}
