func uniqueMorseRepresentations(words []string) int {
    codes := []string{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."}
	a := int32('a')
	m := make(map[string]bool)
	for _, word := range words {
		s := ""
		for _, w := range word {
			s += codes[w-a]
		}

		m[s] = true
	}

	return len(m)
}