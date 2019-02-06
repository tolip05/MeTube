<%@ page import="metube.domein.models.view.TubeDetailsViewModel" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:import url="templates/head.jsp"/>
</head>
<body>

<div class="container-fluid">
    <header>
        <c:import url="templates/navbar.jsp"/>
    </header>
    <main>
        <% TubeDetailsViewModel viewModel = (TubeDetailsViewModel) request.getSession().getAttribute("model");%>
        <hr class="my-2">
        <div class="container-fluid">
            <h2 class="text-center"><%=viewModel.getTitle()%></h2>
            <div class="row">
                <div class="col-md-6 my-5">
                    <div class="embed-responsive embed-responsive-16by9">
                        <iframe class="embed-responsive-item" src="https://www.youtube.com/embed/<%=viewModel.getYoutubeId()%>" allowfullscreen frameborder="0"></iframe>
                    </div>
                </div>
                <div class="col-md-6 my-5">
                    <h1 class="text-center text-info"><%=viewModel.getAuthor()%></h1>
                    <h3 class="text-center text-info"><%=viewModel.getViews()%>View</h3>
                    <div class="h5 my-5 text-center"><%=viewModel.getDescription()%></div>
                </div>
            </div>
        </div>
        <hr class="my-3"/>

    </main>
    <footer>
        <c:import url="templates/footer.jsp"/>
    </footer>
</div>
</body>
</html>
