package com.pengyue.ipo.tree;

import java.util.List;

import com.pengyue.ipo.bean.TbXtSource;

public class FancyTreeData {
	private String title; // 节点显示的文字
	private String key; // 节点的键值
	private String expanded = "expanded"; // 该节点是否展开,默认不展开，展开则设置值为"expanded"
	private String selected = "selected"; // 该节点是否选中，默认不选中，选中则设置值为"selected"
	private List<FancyTreeData> children; // 该节点下的子节点集合
	private boolean folder; // 节点是否是一个文件夹
	private String parentId = ""; // 节点父级key

	public FancyTreeData() {
	}

	public FancyTreeData(TbXtSource tbXtSource) {
		this.title=tbXtSource.getName();
		this.key=tbXtSource.getId();
		this.parentId="0";
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getExpanded() {
		return expanded;
	}

	public void setExpanded(String expanded) {
		this.expanded = expanded;
	}

	public String getSelected() {
		return selected;
	}

	public void setSelected(String selected) {
		this.selected = selected;
	}

	public List<FancyTreeData> getChildren() {
		return children;
	}

	public void setChildren(List<FancyTreeData> children) {
		this.children = children;
	}

	public String title() {
		return this.title;
	}

	public FancyTreeData title(String title) {
		this.title = title;
		return this;
	}

	public boolean isFolder() {
		return folder;
	}

	public void setFolder(boolean folder) {
		this.folder = folder;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String key() {
		return this.key;
	}

	public FancyTreeData key(String key) {
		this.key = key;
		return this;
	}

	public String expanded() {
		return this.expanded;
	}

	public FancyTreeData expanded(String expanded) {
		this.expanded = expanded;
		return this;
	}

	public String selected() {
		return this.selected;
	}

	public FancyTreeData selected(String selected) {
		this.selected = selected;
		return this;
	}

	public List<FancyTreeData> children() {
		return this.children;
	}

	public FancyTreeData children(List<FancyTreeData> children) {
		this.children = children;
		return this;
	}

	public boolean folder() {
		return this.folder;
	}

	public FancyTreeData folder(boolean folder) {
		this.folder = folder;
		return this;
	}

	public String parentId() {
		return this.parentId;
	}

	public FancyTreeData parentId(String parentId) {
		this.parentId = parentId;
		return this;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((children == null) ? 0 : children.hashCode());
		result = prime * result + ((expanded == null) ? 0 : expanded.hashCode());
		result = prime * result + (folder ? 1231 : 1237);
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		result = prime * result + ((parentId == null) ? 0 : parentId.hashCode());
		result = prime * result + ((selected == null) ? 0 : selected.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FancyTreeData other = (FancyTreeData) obj;
		if (children == null) {
			if (other.children != null)
				return false;
		} else if (!children.equals(other.children))
			return false;
		if (expanded == null) {
			if (other.expanded != null)
				return false;
		} else if (!expanded.equals(other.expanded))
			return false;
		if (folder != other.folder)
			return false;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		if (parentId == null) {
			if (other.parentId != null)
				return false;
		} else if (!parentId.equals(other.parentId))
			return false;
		if (selected == null) {
			if (other.selected != null)
				return false;
		} else if (!selected.equals(other.selected))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FancyTreeData [title=" + title + ", key=" + key + ", expanded=" + expanded + ", selected=" + selected
				+ ", children=" + children + ", folder=" + folder + ", parentId=" + parentId + "]";
	}

}
