// Export an object with the isContrastReadable function as a property
export const contrastUtils = {
    isContrastReadable: (
      color1: string,
      color2: string,
      threshold: number = 1.1
    ): boolean => {
      // Calculate the luminance of a color (Y value in the YIQ color space)
      const luminance = (color: string): number => {
        const rgb = parseInt(color.slice(1), 16); // Remove # and convert to integer
        const r = (rgb >> 16) & 0xff; // Red channel
        const g = (rgb >> 8) & 0xff; // Green channel
        const b = rgb & 0xff; // Blue channel
        const y = 0.299 * r + 0.587 * g + 0.114 * b; // Calculate luminance
        return y;
      };
  
      const luminance1: number = luminance(color1);
      const luminance2: number = luminance(color2);
  
      // Calculate the contrast ratio
      const contrastRatio: number =
        (Math.max(luminance1, luminance2) + 0.05) /
        (Math.min(luminance1, luminance2) + 0.05);
  
      // Return a boolean indicating whether the contrast ratio is above the threshold
      return contrastRatio >= threshold;
    },
  };
  