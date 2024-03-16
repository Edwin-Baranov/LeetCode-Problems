func maxRepeating(sequence string, word string) int {
    wordLen := len(word)
    halfWordLen := wordLen / 2
    lastI := len(sequence) - wordLen + 1
    maxSequence := 0
    count := 0
    overlap := 0
    
    for i := 0; i < halfWordLen; i++ {
        if (word[i] != word[wordLen - i - 1]) {
            overlap = i
            break
        }
    }
    
    for i := 0; i < lastI; {
        match := true
        for j := 0; j < wordLen; j++ {
            if (sequence[i + j] != word[j]) {
                match = false
                break
            }
        }
            
        if (match) {
            count++
            i += wordLen
        } else {
            if (count > 0) {
                i = i - overlap
            } else {
                i++
            }
            count = 0
        }
        maxSequence = max(maxSequence, count)
    }
    return maxSequence
}