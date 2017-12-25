<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<ul class="pagination">
	<!-- 计算分页页码 -->
	<c:choose>
		<%-- 如果总数不足10页,那么把所有的页数都显示出来 --%>
		<c:when test="${maxPage <= 10}">
			<c:set var="begin" value="1" />
			<c:set var="end" value="${maxPage}" />
		</c:when>
		<c:otherwise>
			<%-- 当总页数大于10时,通过公式计算出begin和end --%>
			<c:set var="begin" value="${currentPage-4}" />
			<c:set var="end" value="${currentPage+5}" />
			<%-- 如果头溢出 --%>
			<c:if test="${begin < 1}">
				<c:set var="begin" value="1" />
				<c:set var="end" value="10" />
			</c:if>
			<%-- 如果尾溢出 --%>
			<c:if test="${end > maxPage}">
				<c:set var="begin" value="${maxPage-9}" />
				<c:set var="end" value="${maxPage}" />
			</c:if>
		</c:otherwise>
	</c:choose>

	<c:choose>
		<c:when test="${currentPage == 0}">
			<li class="first disabled"><a>首页</a></li>
		</c:when>
		<c:otherwise>
			<li class="first"><a href="javascript:searchPage(0)">首页</a></li>
		</c:otherwise>
	</c:choose>

	<c:choose>
		<c:when test="${currentPage > 0}">
			<li class="prev"><a
				href="javascript:searchPage(${currentPage - 1})">上一页</a></li>
		</c:when>
		<c:otherwise>
			<li class="prev disabled"><a>上一页</a></li>
		</c:otherwise>
	</c:choose>

	<c:forEach var="pg" begin="${begin}" end="${end}">
		<c:choose>
			<c:when test="${pg-1 == currentPage}">
				<li class="page active"><a>${pg}</a></li>
			</c:when>
			<c:otherwise>
				<li class="page"><a href="javascript:searchPage(${pg-1})">${pg}</a>
				</li>
			</c:otherwise>
		</c:choose>
	</c:forEach>

	<c:choose>
		<c:when test="${currentPage < maxPage-1}">
			<li class="next"><a
				href="javascript:searchPage(${currentPage+1})">下一页</a></li>
		</c:when>
		<c:otherwise>
			<li class="next disabled"><a>下一页</a></li>
		</c:otherwise>
	</c:choose>

	<c:choose>
		<c:when test="${currentPage == maxPage-1 || maxPage == 0}">
			<li class="next disabled"><a>尾页</a></li>
		</c:when>
		<c:otherwise>
			<li class="next"><a href="javascript:searchPage(${maxPage-1})">尾页</a>
			</li>
		</c:otherwise>
	</c:choose>
</ul>