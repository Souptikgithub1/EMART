
<div class="container-fluid reset-padding">

    <div id="myCarousel" class="carousel slide" data-ride="carousel">
        <!-- Indicators -->
        <ol class="carousel-indicators">
                <c:set var="count" value="${0}" />
            <c:forEach items="${banners}" var="banner">
                <li data-target="#myCarousel" data-slide-to="${count}" class="active"></li>
                <c:set var="count" value="${count + 1}" />
            </c:forEach>
        </ol>

        <!-- Wrapper for slides -->
        <div class="carousel-inner">
        <c:set var="imgCount" value="${0}" />
        <c:forEach items="${banners}" var="banner">
            <div class="item ${imgCount == 0 ? 'active' : ''}">
                <img src="${banner.bannerImage}" alt="Los Angeles" style="width:100%;">
            </div>
            <c:set var="imgCount" value="${imgCount + 1}" />
        </c:forEach>
        </div>

        <!-- Left and right controls -->
        <a class="left carousel-control" href="#myCarousel" data-slide="prev">
            <span class="glyphicon glyphicon-chevron-left"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="right carousel-control" href="#myCarousel" data-slide="next">
            <span class="glyphicon glyphicon-chevron-right"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>
</div>

