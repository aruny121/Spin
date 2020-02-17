package com.example.arunyadav.wheelrotation;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest({Constants.class, String.class})
public class ConstantsTest {
    @Mock
    Constants constants;



    @Before
    public void setUp(){
        constants = spy(Constants.class);
    }

    @Test
    public void cons() {
        Assert.assertEquals(Constants.ERROR, "ERROR");
        Assert.assertEquals(Constants.SUCCESS_API, "SUCCESS_API");
        Assert.assertEquals(Constants.FAIL_API, "FAIL_API");
        Assert.assertEquals(Constants.FETCHING, "FETCHING");
        Assert.assertEquals(Constants.UPDATED, "UPDATED");
        Assert.assertEquals(Constants.SNACK_FETCHING_RPM, "FETCHING RPM");
        Assert.assertEquals(Constants.SNACK_UPDATED_RPM, "UPDATED RPM");
        Assert.assertEquals(Constants.SNACK_UNABLE_TO_UPDATE_RPM, "UNABLE TO UPDATE RPM");
        }
}
