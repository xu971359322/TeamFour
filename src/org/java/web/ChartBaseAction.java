package org.java.web;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.java.service.impl.ChartServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ChartBaseAction implements ServletRequestAware, ServletResponseAware {

    protected ChartServiceImpl service = new ChartServiceImpl();

    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected HttpSession session;

    protected Integer pageNo = 1;
    protected Integer pageSize = 2;
    protected Integer count;
    protected Integer maxPage;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getMaxPage() {
        return count % pageSize == 0 ? count / pageSize : count / pageSize + 1;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {
        this.request = httpServletRequest;
        this.session = request.getSession();
    }

    @Override
    public void setServletResponse(HttpServletResponse httpServletResponse) {
        this.response = httpServletResponse;
    }
}
