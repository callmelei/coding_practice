
# Definition for a undirected graph node
# class UndirectedGraphNode:
#     def __init__(self, x):
#         self.label = x
#         self.neighbors = []

class Solution:
    # @param node, a undirected graph node
    # @return a undirected graph node
    def cloneGraph(self, node):
    """
    12 / 12 test cases passed.
    Status: Accepted
    Runtime: 89 ms
    52.5%
    DFS
    because there is a possiblity that the node will be reference twice
    we can use hash table to avoid duplicated copy
    time complexity: O(N)
    space complexity: O(N)
    """
        if node == None:
            return None
        self.headHash = {}
        
        return self.dfs(node)
        
    def dfs(self, node):
        if node in self.headHash:
            return self.headHash[node]
        else:
            newNode = UndirectedGraphNode(node.label)
            self.headHash[node] = newNode
            for neighbor in node.neighbors:
                newNode.neighbors.append(self.dfs(neighbor))
            return newNode


class Solution:
    # @param node, a undirected graph node
    # @return a undirected graph node
    def cloneGraph(self, node):
    """
    12 / 12 test cases passed.
    Status: Accepted
    Runtime: 92 ms
    43.48%
    DFS
    """
        if node == None:
            return None
        nodecopy = UndirectedGraphNode(node.label)
        dic = {node: nodecopy}
        
        self.dfs(node, dic)
        
        return nodecopy
        
    def dfs(self, node, dic):
        for neighbor in node.neighbors:
            if neighbor in dic:
                dic[node].neighbors.append(dic[neighbor])
            else:
                nodecopy = UndirectedGraphNode(neighbor.label)
                dic[neighbor] = nodecopy
                dic[node].neighbors.append(dic[neighbor])
                self.dfs(neighbor, dic)

class Solution:
    # @param node, a undirected graph node
    # @return a undirected graph node
    def cloneGraph(self, node):
"""
12 / 12 test cases passed.
Status: Accepted
Runtime: 72 ms
99.75%
"""

        if node == None:
            return None
        nodecopy = UndirectedGraphNode(node.label)
        dic = {node: nodecopy}
        que = []
        que.append(node)
        self.bfs(que, dic)
        
        return nodecopy
        
    def bfs(self, que, dic):
        while len(que) > 0:
            node = que.pop()
            for neighbor in node.neighbors:
                if neighbor in dic:
                    dic[node].neighbors.append(dic[neighbor])
                else:
                    nodecopy = UndirectedGraphNode(neighbor.label)
                    dic[neighbor] = nodecopy
                    dic[node].neighbors.append(dic[neighbor])
                    que.append(neighbor)
