class Solution:
        def numberOfWeakCharacters(self, properties: List[List[int]]) -> int:

            properties.sort(key= lambda x:(x[0],-x[1]))
            st,c = [],0
            for ele in properties:
                while st and st[-1][0]<ele[0] and st[-1][1]<ele[1]:
                    st.pop()
                    c+=1
                st.append(ele)

            return c