package com.granovskiy.controller;

import com.granovskiy.web.Request;
import com.granovskiy.web.ViewModel;

public interface Controller {
        ViewModel process(Request req);
}
